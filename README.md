# 🧭 Woori Card Eureka Server

우리카드 MSA(Microservice Architecture) 프로젝트의 **서비스 디스커버리(Service Discovery)** 를 담당하는 핵심 서버입니다. 



모든 마이크로서비스(승인, 정산, 매입 등)는 기동 시 이 서버에 자신의 네트워크 위치를 등록하며, 서비스 간 통신 시 물리적 주소 대신 **서비스 이름**을 통해 서로를 식별할 수 있게 합니다.

---

## 🏗 주요 역할
* **Service Registration**: 각 마이크로서비스의 인스턴스 정보 저장 및 관리
* **Service Discovery**: API Gateway 및 각 서비스가 다른 서비스의 위치를 찾을 수 있도록 정보 제공
* **Health Check**: 등록된 서비스들의 상태를 주기적으로 확인하여 가용성 확보

---

## 🚀 실행 방법 (Getting Started)

### 1. 사전 요구 사항
* **Java 17** 이상
* **Gradle**

### 2. 서버 기동
이 서버는 프로젝트 인프라의 시작점입니다. **가장 먼저 실행**되어야 합니다.

```bash
./gradlew bootRun
```

* **Default Port**: `8761`
* **Service Name**: `wooricard-eureka`

---

## 🚦 인프라 실행 순서 (Dependency)

MSA 구조의 안정적인 구동을 위해 아래 순서를 권장합니다.

1. **Eureka Server** (본 서비스) ◀ **NOW**
2. **[Config Server](../wooricard-config)**: Eureka 등록 후 설정 정보 서빙 시작
3. **Microservices**: Gateway 및 도메인 서비스(Approval, Settlement 등) 실행

---

## 🔍 모니터링 및 상태 확인

서버 실행 후 웹 브라우저를 통해 실시간 등록 현황을 확인할 수 있습니다.

* **Eureka Dashboard**: [http://localhost:8761](http://localhost:8761)
    * **Status**: 현재 실행 중인 인스턴스 목록 확인 가능
    * **General Info**: 서버의 메모리 및 리소스 사용량 확인

---

## 📘 팀원용 클라이언트 설정 가이드
팀원분들이 각자의 프로젝트를 Eureka에 연결하는 상세 방법은 아래 가이드 문서를 참고해 주세요.

👉 **[Eureka Client 설정 가이드 바로가기 (GUIDE.md)](./GUIDE.md)**

---

### 💡 팁
* 로컬 환경에서 테스트 시, 서비스가 정상적으로 등록되지 않는다면 `application.yml`의 `eureka.instance.prefer-ip-address` 설정이 `true`인지 확인하세요.
* 서비스 네이밍 규칙은 반드시 가이드에 명시된 이름을 사용해야 API Gateway 라우팅이 정상 동작합니다.
