# 🚀 팀원 가이드 (Eureka Client 설정)

승인/결제, 정산, 매입 청구 및 API Gateway 담당자분들은 본인의 프로젝트에 아래 설정을 적용하여 유레카 서버에 등록해 주세요.

## 1. 의존성 추가 (build.gradle)
```groovy
dependencies {
    // Eureka Client 라이브러리 추가
    implementation 'org.springframework.cloud:spring-cloud-starter-netflix-eureka-client'
}
```

## 2. 설정 추가 (application.yml)
서비스 이름은 아래 **[서비스 네이밍 규칙]** 을 참고하여 통일해 주세요.

```yaml
spring:
  application:
    name: [명세서의 서비스명 입력] # 예: wooricard-approval-service

eureka:
  client:
    service-url:
      defaultZone: http://192.168.1.80:8761/eureka/
  instance:
    # 각자의 컴퓨터 이름을 인식하지 못할 수 있으므로 IP 주소 기반 등록 권장
    prefer-ip-address: true
```

## 3. 유레카 활성화 (Main 클래스)
메인 애플리케이션 클래스 상단에 어노테이션을 추가합니다.

```java
@SpringBootApplication
@EnableDiscoveryClient // 유레카 클라이언트 활성화
public class YourServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(YourServiceApplication.class, args);
    }
}
```

---

# 📋 서비스 네이밍 규칙 (통일 필수)

유레카 대시보드에 표시될 서비스 이름입니다. API Gateway 설정과 연동되므로 반드시 아래 이름을 사용해 주세요.

| 역할 | 서비스 이름 (`spring.application.name`) | 담당자    | 포트 |
| :--- | :--- |:-------| :--- |
| **Service Discovery** | `wooricard-eureka` | **민영** | 8761 |
| **API Gateway** | `wooricard-gateway` | 경록     | 8080 |
| **승인/결제 서비스** | `wooricard-approval-service` | 유림     | 8081 |
| **정산 서비스** | `wooricard-settlement-service` | 색빛     | 8082 |
| **매입 청구 서비스** | `wooricard-billing-service` | 민정     | 8083 |
| **Config server** | `wooricard-config-server` | 민영     | 8888 |


