package com.springapp.mvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class HelloControllerTest3 {

    @Mock
    HelloService helloService;

    @InjectMocks
    HelloController helloController;


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testController() throws Exception {

        // @RunWith(MockitoJUnitRunner.class)
        // Mockito 컨트롤러 테스트
        // service layser(이 경우 HelloService 클래스의 hello(String name) 메소드를 mock으로 대체
        // 서비스 레이어에 대한 테스트는 컨트롤러 테스트영역 밖이므로 별도의 서비스 레이어 테스트 클래스에서 비지니스 로직 테스트.

        String viewName = helloController.test1("name");

        assertThat(viewName, is("test1"));

        // mockito를 통해 helloController에서 호출한 service layer의 method가 정상 호출 되었는지검사.
        Mockito.verify(helloService, Mockito.times(1)).hello(Mockito.anyString());
        Mockito.verifyNoMoreInteractions(helloService);
    }
}
