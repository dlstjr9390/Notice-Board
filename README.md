# Notice-Board 
TODO 사이트 만들기
# 개발기간
2023-11-10 ~ 2023-11-20 
# 구현할 기능
- [x] 회원가입 기능
- [x] 로그인 기능
- [x] 할일 작성 기능
- [x] 할일 목록 조회 기능
- [x] 선택한 할일 조회 기능
- [x] 할일 수정 기능
- [x] 할일 완료 기능
- [ ] 댓글 작성 기능
- [ ] 댓글 수정 기능
- [ ] 댓글 삭제 기능

# 구현하지 못한 것과 이유
JWT 토큰 검증을 통해 사용자 인증 인가 과정을 진행해야 하는데 JWT 활용이 미숙해 구현하지 못함.<br>
이를 활용한 로그인된 유저와 작성된 할일의 글쓴이가 같은지 비교하지 못했음<br>
그리고 이러한 문제를 해결하느라 댓글기능을 구현하지 못함.


# API
| 기능       | Method | URL                      | request                                                                   | response   |
|:---------|:-------|:-------------------------|:--------------------------------------------------------------------------|:-----------|
| 회원가입     | POST   | /api/user/signup         | {'username': username, 'password' : password, 'email' : email }           |            |
| 로그인      | POST   | /api/user/login          | {'username': username, 'password' : password}                             |            |
| 할일 작성    | POST   | /api/board               | {'title':title, 'writer':writer, 'contents':contents}                     | 등록된 할일 정보  |
| 할일 목록 조회 | GET    | /api/board               |                                                                           | 등록된 할일 정보  |
| 할일 조회    | GET    | /api/board/{id}          |                                                                           | 선택된 할일 정보  |
| 할일 수정    | PUT    | /api/board/{id}          | {'title':title, 'writer':writer, 'password': password, 'content':content} | 수정된 할일의 정보 |
| 할일 완료    | PUT    | /api/board/complete/{id} |                                                                           |   |

