package com.springapp.mvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class HelloControllerTest2 {

    @Mock
    HelloService helloService;

    @InjectMocks
    HelloController helloController;

    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");

        // 스크링에서 controller 테스트를 위해 제공한 mockMVC 를 통해  helloController 테스트
        this.mockMvc = MockMvcBuilders.standaloneSetup(helloController)
            .setViewResolvers(viewResolver)
            .build();
        // service layer를 mock으로 대체하기 위해 mockito 라이브러리 사용.
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testController() throws Exception {

        // @RunWith(MockitoJUnitRunner.class)
        // Mockito + Spring MockMvc 조합으로 컨트롤러 테스트
        // service layser(이 경우 HelloService 클래스의 hello(String name) 메소드를 mock으로 대체
        // 서비스 레이어에 대한 테스트는 컨트롤러 테스트영역 밖이므로 별도의 서비스 레이어 테스트 클래스에서 비지니스 로직 테스트.

        when(helloService.hello(isA(String.class)))
            .then(invocation -> Boolean.TRUE);

        // test 할 conroller url과 param 세팅.
        mockMvc.perform(get("/test1").param("name", "thswave"))
            .andExpect(status().isOk())
            .andExpect(view().name("test1"))
            .andDo(print());

//         rest api에서 put + json 응답의 경우  아래와같이 입력 body 값을 정의할 수 있습니다.
//        mockMvc.perform(put("/test/{id}", "id", 1)
//            .contentType(MediaType.APPLICATION_JSON)
//            .header("header-name", "header")
//            .content("{\n" +
//                "    \"put\": data\n" +
//                "}"))
//            .andExpect(status().isOk())
//            .andDo(print());
    }
}
