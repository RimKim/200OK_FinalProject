package shop.myshop.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import shop.myshop.dto.UserDTO;
import shop.myshop.entity.User;
import shop.myshop.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public User join(User user) {
		return userDao.save(user);
	}

	@Override
	public Boolean isUser(String id, String pwd) throws Exception {
		List<User> list = userDao.findByUserIdAndUserPwd(id, pwd);
		return list.stream().anyMatch((user) -> user.getUserId().equals(id) && user.getUserPwd().equals(pwd));
	}

	@Override
	public UserDTO findByUserId(String id) throws Exception {
		User user = userDao.findByUserId(id);
		if (user == null) {
			return null;
		}
		return modelMapper.map(user, UserDTO.class);
	}

	@Override
	public List<UserDTO> findAll() throws Exception {
		List<User> userList = userDao.findAll();
		return userList.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
	}

	// 아이디찾기
	@Override
	public String getUserId(String userName, String userEmail) throws Exception {
		return userDao.findByUserNameAndUserEmail(userName, userEmail);

	}

	@Override
	public User findUserPwd(String userId, String userName, String userEmail) throws Exception {
		return userDao.findByUserIdAndUserNameAndUserEmail(userId, userName, userEmail);
	}

	@Override
	public int updateTempPwd(String tempPwd, String userId) throws Exception {
		return userDao.updateTempPwd(tempPwd, userId);
	}

	@Override
	public JsonNode getKakaoAccessToken(String code) {
		final String RequestUrl = "https://kauth.kakao.com/oauth/token"; // Host
		final List<NameValuePair> postParams = new ArrayList<NameValuePair>();

		postParams.add(new BasicNameValuePair("grant_type", "authorization_code"));
		postParams.add(new BasicNameValuePair("client_id", "카카오아이디")); // REST API KEY
		postParams.add(new BasicNameValuePair("redirect_uri", "http://localhost/ok/user/kakao")); 
																									
		postParams.add(new BasicNameValuePair("code", code)); // 로그인 과정중 얻은 code 값

		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost post = new HttpPost(RequestUrl);

		JsonNode returnNode = null;

		try {
			post.setEntity(new UrlEncodedFormEntity(postParams));

			final HttpResponse response = client.execute(post);
			final int responseCode = response.getStatusLine().getStatusCode();

			System.out.println("\nSending 'POST' request to URL : " + RequestUrl);
			System.out.println("Post parameters : " + postParams);
			System.out.println("Response Code : " + responseCode);

			// JSON 형태 반환값 처리
			ObjectMapper mapper = new ObjectMapper();

			returnNode = mapper.readTree(response.getEntity().getContent());

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}

		return returnNode;
	}

	public HashMap<String, Object> getUserInfo(String access_Token) {

		// 요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
		HashMap<String, Object> userInfo = new HashMap<>();
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");

			// 요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer " + access_Token);

			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);

			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);

			JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
			JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

			String nickname = properties.getAsJsonObject().get("nickname").getAsString();
			String email = kakao_account.getAsJsonObject().get("email").getAsString();

			userInfo.put("nickname", nickname);
			userInfo.put("email", email);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userInfo;
	}

	@Override
	public boolean UserIdExists(String userId) throws Exception {
		Optional<User> optionalUser = userDao.existsByUserId(userId);

		return optionalUser.isPresent();
	}
	
	@Override
	public void deleteByUserId(String userId) throws Exception{
		userDao.deleteById(userId);
	}


}
