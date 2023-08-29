## Inflearn

<img src="https://github.com/JHyun0302/server/assets/60764632/24cec8a1-ddb4-42c4-8e5b-2ff8d8fe6f49"  width="600" height="300"/>

### 강의명 : [스프링 부트 - 핵심 원리와 활용](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-%ED%95%B5%EC%8B%AC%EC%9B%90%EB%A6%AC-%ED%99%9C%EC%9A%A9)

- 지식공유자 : 김영한

### 강의 내용

- 스프링 부트가 제공하는 5가지 핵심 기능
    1. 내장 서버
    2. 자동 라이브러리 관리
    3. 자동 구성
    4. 외부 설정
    5. 모니터링 & 관리 기능

- 정리 : `actuactor`
    - '.yml' 파일에 설정값 관리
        - 'endpoints' 설정
            1. 엔드포인트 활성화 (on or off) : 대부분은 활성화 상태 (`shutdown` 제외 : 서버 꺼짐)
            2. 엔드포인트 노출 (HTTP or JMX 노출 위치 지정)
        - **"엔드포인트 활성화 + 노출 = 사용 가능"**

    - health, info, loggers, httpexchanges, git, metrics 등 다양한 정보 제공

    - build
        - build.gradle 추가
            - `springBoot { buildInfo() }`
    - git
        - `git init` 된 상태에서
        - build.gradle 추가
            - `plugins { id "com.gorylenko.gradle-git-properties" version "2.4.1" }`

    - 실시간 로그 레벨 변경
        1. Postman 설정 (Post, JSON)
        2. body 내용 ({ "configuredLevel" : "Trace" })
        3. 결과 : 로그 레벨 Trace로 변경

    - HTTP 요청 응답 기록
        - `ActuatorApplication` 참고

    - **tag 필터 : 더 자세한 항목 검색**
        - '힙 메모리 영역' : `http://localhost:8080/actuator/metrics/jvm.memory.used?tag=area:heap`
        - '/log 요청만 필터' : `http://localhost:8080/actuator/metrics/http.server.requests?tag=uri:/log`

    - JVM 메트릭
        - `jvm.` 으로 시작

    - 시스템 메트릭
        - `system.`, `process.`, `disk.`으로 시작

    - 애플리케이션 시작 메트릭
        - `ApplicationStartedEvent` : 스프링 컨테이너가 완전히 실행된 상태. 이후에 케맨드 라인 러너 호출
            - 스프링 띄우는데 걸리는 시간
        - `ApplicationReadyEvent` : 커맨드 라인 러너 실행된 이후에 호출
            - 스프링 띄우고 init 데이터 등 처음 설정한 메서드 실행된 상태.

    - 스프링 MVC 메트릭
        - `http.server.requests` 으로 시작

    - 데이터소스 메트릭
        - `jdbc.connections.`으로 시작

    - 로그 메트릭
        - `logback.events`으로 시작
      
    - 톰캣 메트릭
        - `tomcat.` 으로 시작 