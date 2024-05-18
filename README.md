# 1차 과제

# 1. 서비스 소개

- 서비스 이름 : `난 0ㅣ서`
- 서비스 소개 : 표현하자니 사소해보이고 무시하자니 신경쓰이는 서운함이 있다. 불편한 감정을 묵히지 않으면서도 작은 서운함이 커지지 않도록! 사소한 서운함을 토로하고 위로하는 채팅앱.

# 2. API 명세서 & 역할 분배

- GET
    - 친구 목록 조회
        
        ### API 소개
        
        회원의 pk, memberId로 존재하는 친구들의 목록을 조회합니다. 
        
        ## request
        
        ### request header
        
        `memberId : long`
        
        ## response
        
        ### success : 200 OK
        
        ```json
        {
        	"friends":{
        	[
        		"name" : "홍길동", 
        		"friend_zero_account" : 12,
        		"imgUrl" : "www.naver.com"
        	],
        	[
        		"name" : "엄복동", 
        		"friend_zero_account" : 13,
        		"imgUrl" : "www.naver.com"
        	}
        }
        ```
        
        ### fail : 400 BAD_REQUEST
        
        ```json
        {
        	"status" : 400,
        	"message" : "찾을 수 없습니다."
        }
        ```
        
    - 채팅 목록 조회
        
        ### API 소개
        
        유저의 PK 로 유저가 가지고 있는 채팅방을 모두 조회합니다.
        
        ## Request
        
        ### RequestHeader
        
        `memberId : Long` 
        
        ## Response
        
        ### Success : 200 OK
        
        response : 
        
        ```json
        {
        	"chatingRooms" : {
        	[
        		"id":1,
        		"memberId" : 3,
        		"friendId" : 4
        	],[
        		"id":2,
        		"memberId" : 3,
        		"friendId" : 5
        	],[
        		"id":3,
        		"memberId" : 3,
        		"friendId" : 6
        	]
        	}
        }
        ```
        
    - 대답 조회
        
        ### API 소개
        
        현재 존재하는 채팅방의 대답을 조회합니다. 
        
        ## Request
        
        ### request header
        
        `memberId : long` 
        
        ### request param
        
        `chatroomId : long`
        
        ## Response
        
        ### Success : 200 OK
        
        response : 
        
        ```json
        {
        "data" : {
        	"friendId" : 1,
        	"message" : "난 이게 서운해"
        	}
        }
        ```
        
    - 내 프로필 조회
        
        ### API 소개
        
        회원의 pk, memberId로 프로필을 조회합니다. 
        
        ## request
        
        ### request header
        
        `memberId : long`
        
        ## response
        
        ### success : 200 OK
        
        ```json
        {
        	"name" : "홍길동", 
        		"friend_zero_account" : 12,
        		"imgUrl" : "www.naver.com"
        }
        ```
        
        ### fail : 400 BAD_REQUEST
        
        ```json
        {
        	"status" : 400,
        	"message" : "찾을 수 없습니다."
        }
        ```
        
- POST
    - 질문 추가
        
        ### API 소개
        
        questionId를 키로 새 질문을 post하는 api
        
        ## request
        
        ### request header
        
        `memberId : long`
        
        `friendId : long`
        
        ## response
        
        ### success : 201 CREATED
        
        ```json
        {
        }
        ```
        
        ### fail : 400 BAD_REQUEST
        
        ```json
        {
        	"status" : 400,
        	"message" : "찾을 수 없습니다."
        }
        ```
        
- PUT
- DELETE
    - 채팅방 삭제
        
        ### API 소개
        
        회원 ID와 chatroomId 를 이용하여 채팅방을 삭제합니다. 
        
        ## Request
        
        ### Request header
        
        `memberId : long`
        
        ### Requset param
        
        `chatroomId : long`  
        
        ## Response
        
        ### Success : 200 OK
        
        ```json
        {
        	"message" : "정상 삭제되었습니다."
        }
        ```
        
        ### Fail : 400 BAD_REQUEST
        

# 3. 코드 컨벤션

### 📌 네이밍 규칙

```
/api/auth
/api/users
/api/meetings
/api/books
```

- 복수형을 사용합니다
- 확장자는 포함하지 않습니다.
- 소문자를 사용합니다.
- `_` 대신 `-`를 사용합니다.
- 마지막에 `/` 를 포함하지 않습니다.
- HTTP Method로 구분할 수 있는 get, put 등의 행위는 url에 표현하지 않습니다.

URL은 RESTful API 설계 가이드에 따라 작성합니다.

### URL

```
- Entity명 + Controller
ex) UserController
```

- 컨트롤러 클래스명

```
- Entity명 + Service
ex) UserSevice
```

- 서비스 클래스명

```java
controller: UserController
service: UserService
repository: UserRepository
dto/request: UserRequest
dto/response: UserResponse
entity: User
config: WebConfig
exception: UserNotFoundException
```

- 구현체의 경우 ~ Impl를 접미사에 추가합니다. (ex. UserServiceImpl, UserRepositoryImpl)
- 각 패키지명을 접미사에 명시합니다.

### 클래스명

- 메소드의 목적을 동사로 표현해 메소드의 앞에 붙입니다.
    - find~, add~, update~, remove~, create~
- 의도가 전달되도록 최대한 간결하게 표현합니다.
- 메소드의 부수효과를 구체적으로 설명합니다.
    
    ```java
    void getTemp() {
    	Object temp = findTemp();
    	if (temp == null) {
    		temp = new Temp();
    	}
    	return temp;
    }
    ```
    
    해당 예시에서, 단순히 Temp를 조회하는 것이 아니고 비어있으면 새롭게 생성하는 역할을 하고 있습니다. 따라서 `getTemp` 보다 `getOrCreateTemp()` 가 적절합니다. 단, 위는 예시일 뿐 **한 개의 메소드는 한 개의 역할만 하는 것을 지향합니다**.
    
- event, design과 같은 **이중적인 뜻을 가지는 단어는 지양합니다**.

```
- HTTPMethod + Entity명
ex) getUsers
```

**메소드명**

```
- Entity명 + Response or Request + Dto
ex) UserResponseDto
```

**Dto명**

### 함수 네이밍

```java
public static UserResponseDto of(Long id, String nickName, Rank userRank, int point, 
																	int coupon, long interest, int waiting, int finish,
																	int ready, int delivering, int delivered, 
																	String address, String phoneNumber) {
				...
    }
}
```

- 함수 정의가 `**최대 길이를 초과하는 경우**`에는 아래와 같이 줄바꿈합니다.

### 줄바꿈

- 클래스 내 변수는 한 줄 공백을 두고 작성합니다.
- 들여쓰기에는 탭(tab) 대신 **4개의 space**를 사용합니다.

### **들여쓰기 및 띄어쓰기**

- 주석 관련
    - 주석 작성 시 띄어쓰기 넣기
    - 위에 쓰기
- Type Assertion
    - type 지정 필수
        - 변수, 함수 모두
    - 서비스 단에서 스키마와 관련된 변수 및 함수 타입 단언은 경우의 따라 단언을 하지 않을 수 있다.
- Exception
    - 서비스 로직에 관련된 예외는 서비스 단에서 던지기
    - validation 관련 예외는 컨트롤러 단에서 던지기

### 📌  그 외 코드 작성 시 유의 사항

1. 패키지
    - controller
    - service
    - repository
2. 폴더명
    - 소문자 사용

### 📌  프로젝트 폴더링명

- 명사는 단수로 쓰지 않되 개수를 나타내는 단어 꼭 적어주기
    - ex. 복수 : getUsers() / 단수 : getUser()
    
- 변수명 : 명사+명사 or 형용사+명사
- 함수명 : 동사+명사
    - API와 직결되는 함수는 CRUD 명칭을 앞에 달기
        - ex. Create → create000
              Read → get000 (getUserById, getUsers)
              Update → update000
              Delete → delete000
- lowerCamelCase 사용
    - 클래스, 인터페이스, db스키마의 경우 Upper**CamelCase**

# 4. 프로젝트 폴더링

![555](https://github.com/34th-SOPT-SOPKATHON-2/Server/assets/43662405/fb9806fd-6fe2-4947-9487-cc9ec9ef5f22)



# 5. ERD 캡처사진

 ![Untitled](https://github.com/34th-SOPT-SOPKATHON-2/Server/assets/43662405/36a6e56b-0dbf-4c70-83d9-cba3a2565c3b)
