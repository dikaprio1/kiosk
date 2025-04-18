# Kiosk Program - Developer README

## 프로젝트 개요

이 키오스크 프로그램은 사용자가 메뉴를 선택하고 주문을 처리할 수 있도록 설계되었습니다. Java로 개발되었으며, 객체 지향 프로그래밍 원칙을 준수하여 유지보수와 확장이 용이하게 구성되었습니다.

## 프로젝트 구조

/src
- Category.java      # 카테고리 관리
- Discount.java      # 할인 로직
- Kiosk.java         # 키오스크 핵심 로직
- Main.java          # 메인 실행 파일
- Menu.java          # 메뉴 관리
- MenuItem.java      # 개별 메뉴 아이템
- Order.java         # 주문 처리 로직


## 설치 및 실행 방법

### 1. 환경 설정

이 프로젝트는 Java 11 이상에서 실행됩니다.

**필수 소프트웨어:**

- Java Development Kit (JDK) 11+
- IntelliJ IDEA 또는 Eclipse (권장)

### 2. 프로젝트 실행

1. IntelliJ IDEA에서 `kiosk` 프로젝트를 엽니다.
2. `Main.java`를 실행하여 프로그램을 시작합니다.

## 주요 기능

- **메뉴 관리:** 사용자가 메뉴에서 항목을 선택할 수 있음
- **주문 처리:** 주문 내역을 생성하고 결제 가능
- **할인 기능:** 특정 조건에 따라 할인 적용 가능

## 기여 방법

1. 이 저장소를 포크합니다.
2. 새로운 기능을 추가하거나 버그를 수정합니다.
3. 변경 사항을 커밋하고 풀 리퀘스트(PR)를 생성합니다.
