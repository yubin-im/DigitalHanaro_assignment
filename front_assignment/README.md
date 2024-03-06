# 🌟 프론트엔드 실습 과제 🌟

## 🚩 구현 과제

### 레이아웃

- 로그인 화면 (첫 화면)
- 앨범 목록 화면
- 상세(앨범 사진) 화면

### API 이용

- 로그인
  - https://jsonplaceholder.typicode.com/users/{userId}
- 앨범 목록
  - https://jsonplaceholder.typicode.com/albums?userId={userId}
- 앨범 상세 정보
  - https://jsonplaceholder.typicode.com/albums/{albumId}
- 특정 앨범의 사진 목록
  - https://jsonplaceholder.typicode.com/photos?albumId={albumId}

### 개발 환경

#### [Front-end]

<img src="https://img.shields.io/badge/React-61DAFB?style=flat-square&logo=React&logoColor=black">
<img src="https://shields.io/badge/TypeScript-3178C6?logo=TypeScript&logoColor=FFF&style=flat-square">
<img src="https://img.shields.io/badge/HTML5-E34F26?style=flat-square&logo=html5&logoColor=white">
<img src="https://img.shields.io/badge/CSS3-1572B6?style=flat-square&logo=css3&logoColor=white">
<img src="https://img.shields.io/badge/Tailwind CSS-06B6D4?style=flat-square&logo=Tailwind CSS&logoColor=white">

#### [Tool & Environment]

<img src="https://img.shields.io/badge/Visual Studio Code-007ACC?style=flat-square&logo=Visual Studio Code&logoColor=white">
<img src="https://img.shields.io/badge/Git-F05032?style=flat-square&logo=git&logoColor=white">
<img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white">

### 필수 요구 사항

1. useEffect와 fetch(axios) 사용하기
2. clean-up 함수를 작성(abort)하여 네트워크 통신을 취소시킬 수 있도록 하기
3. 로그인된 사용자는 useContext와 useReducer을 사용하여 작성하기
4. 로컬 스토리지에 저장하여 로그인 사용자 지속시키기
5. 앨범 목록은 현재 로그인된 유저의 앨범이며, 앨범 선택 후 ‘앨범 상세보기’ 클릭 시 상세 화면으로 이동하기 (선택은 한 개만)
6. 페이지 전환은 react-route-dom 사용하고, 상세 화면에서 다시 돌아왔을 때 이전과 동일하게 보이기 (history.back 사용 금지)
7. 상세 화면에서 사진의 썸네일 이미지 보이기, 새로고침 시 사진 똑같이 보이기
8. 간단하고 가독성 좋은 코드 작성하기
9. UI 보다 UX에 집중하고 버그가 없도록 작성하기
10. CRA나 Vite 등을 사용하여 프로젝트 생성 하기
11. node_modules 폴더만 제외하고 프로젝트 전체 압축 후 제출하기 (yarn dev 만 눌러도 실행 가능하도록)

## 🖥️ 프로젝트 실행 방법

#### 1. node_modules 설치

- cmd 창 프로젝트 최상단 디렉터리로 이동
- **npm install express** 입력

#### 2. 프로젝트 실행

- cmd 창 프로젝트 최상단 디렉터리로 이동
- **yarn dev** 입력
- localhost:3000 접속

#### 그 외 상황

- yarn이 없을 때 (yarn 설치)
  - cmd 창 프로젝트 최상단 디렉터리로 이동
  - **npm install -g yarn** 입력

## 🚀 구현 과정

### [[프론트엔드 실습 과제] 개발 일지 (클릭!)](https://unleashed-fire-109.notion.site/bd3e8ccc518947df8fd764ac8bb24f40?pvs=4)
