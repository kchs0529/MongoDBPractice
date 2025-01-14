# MongoDBPractice

이 프로젝트는 **Java**와 **MongoDB**를 사용하여 간단한 도서 관리 시스템을 구현한 콘솔 애플리케이션입니다. 사용자는 책을 추가하고, 조회하고, 수정하는 기능을 사용할 수 있습니다. MongoDB를 데이터베이스로 사용하여 책 데이터를 저장하고 관리합니다.

---

## **목차**

1. [프로젝트 소개](#프로젝트-소개)
2. [기능](#기능)
3. [기술 스택](#기술-스택)
4. [설치 방법](#설치-방법)




---

## **프로젝트 소개**

이 프로젝트는 **도서 관리 시스템**으로, Java 언어와 MongoDB를 활용하여 책을 관리할 수 있는 기능을 제공합니다. MongoDB를 이용해 책의 제목, 저자, 출판 연도 등의 정보를 데이터베이스에 저장하며, 사용자에게 책 목록을 조회하고, 책 정보를 수정하는 기능을 제공합니다.

---

## **기능**

- **책 추가**: 사용자가 책 정보를 입력하여 도서 목록에 추가할 수 있습니다.
- **책 수정**: 기존의 책 정보를 수정할 수 있습니다.
- **책 삭제**: 책을 삭제할 수 있습니다.
- **책 조회**: 등록된 모든 책 정보를 조회할 수 있습니다.

---

## **기술 스택**

- **Java 11**: 백엔드 로직을 구현하는 데 사용되었습니다.
- **MongoDB**: 데이터베이스로 사용되어 책 정보를 저장합니다.
- **Eclipse IDE**: Java 프로젝트를 관리하고 실행하는 데 사용되었습니다.
- **Maven**: 의존성 관리를 위한 빌드 도구로 사용되었습니다.

---

## **설치 방법**

1. **프로젝트 클론**:
   ```bash
   git clone https://github.com/yourusername/your-project-name.git
2. **필요한 라이브러리 설치**:
   - MongoDB Java Driver JAR 파일을 다운로드
   - 다운로드한 JAR 파일을 프로젝트의 `Build Path`에 추가
    1. 프로젝트 우클릭 → `Build Path` → `Configure Build Path`.
    2. `Libraries` 탭 → `Add External JARs` 클릭.
    3. JAR 파일을 선택하고 적용합니다.
