package com.chadi.aws;

import com.chadi.aws.controller.HomeController;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;

//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class DemoApplicationTests {

	//@Autowired
	//private WebApplicationContext webApplicationContext;


//	@Test
//	void contextLoads() {
//	}

	//@Test
	public void testDownload() throws Exception {
//		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//		mockMvc.perform(MockMvcRequestBuilders.
//				get("http://localhost:8080/api/storage/download?fileName=testFile.txt"))
//				.andExpect(status().is(200));
//				//.andExpect(content().contentType("application/octet-stream"));
	}

	@Test
     public void testHomeController() {
			HomeController homeController=new HomeController();
			String result= homeController.helloWorld();
			assertEquals(result,"hello-world");
	}

}
