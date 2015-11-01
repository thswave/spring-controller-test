### Spring Controller Test project

#### src/test/java/com.springapp.mvc/HelloControllerTest1

* MockMvc 를 통한 컨트롤러 테스트

#### src/test/java/com.springapp.mvc/HelloControllerTest1

* MockMvc + Mockito  를 통한 컨트롤러 테스트

#### src/test/java/com.springapp.mvc/HelloControllerTest1

* Mockito 를 통한 컨트롤러 테스트



컨트롤러 테스트는 여러 가지 방법으로 테스트가 가능.
input(컨트롤러의 경우 uri + parameter 등)에 대한 output 테스트.

Service Layer 는 별도의 테스트하는것이 좋음.


##### Mockito와 MockMvc의 차이

* Mockito: @Mock, @InjectMock 을 통해 Mocking하여 테스트. 간단하게 입력 값에 대해 응답을 검사하기 용이.

* MockMvc: Spring test가 controller 테스트를 위해 제공 configuration 파일을 읽어
Interceptor나 AOP 등 모든 설정을 실제 서비스와 동등하게 동작.

