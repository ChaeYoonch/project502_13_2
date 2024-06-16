JAVA -> MVC model

- MVC 정리 (출처 : Youtube 우아한테크 https://www.youtube.com/watch?v=ogaXW6KPc8I)

- MVC 개념
![image](https://github.com/ChaeYoonch/project502_13_2/assets/163954005/d1283636-d2f0-46b8-aa06-7d90c35df76d)

- MVC 구조도 예시 
![image](https://github.com/ChaeYoonch/project502_13_2/assets/163954005/280873bd-6df2-4a8f-9847-989939962ed5)

- MVC 각각의 정의
![image](https://github.com/ChaeYoonch/project502_13_2/assets/163954005/242e519a-ef37-4911-8343-023fcd46c8a5)

<M : 데이터 관련 부분 정의 / V : 사용자에게 보여지는 부분 정의 / C : M & V 중개하는 다리 역할 정의>

- MVC 작성 유의사항

1) Model 내부에 Controller 와 View 관련된 코드를 넣지 말라! (데이터와 관련된 부분만 작성 -> Controller or View 에 의존 X)
![image](https://github.com/ChaeYoonch/project502_13_2/assets/163954005/d2df2f5d-b789-4b05-8b6f-f4fb43ffd980)

2) View 는 Model 에만 의존, Controlller 에는 의존 X (View 내부에 Model 관련 코드 O but, Controller 관련 코드 X)
![image](https://github.com/ChaeYoonch/project502_13_2/assets/163954005/070871ce-fcd8-49ee-96ae-2a0181f6ace7)

3) View 가 Model 의 데이터를 사용할 때, 공통으로 보여지는 부분이 아닌 사용자별로 다르게 나타나야하는 부분만 가져올 것!
![image](https://github.com/ChaeYoonch/project502_13_2/assets/163954005/30fa6cce-fa46-4e45-8d7e-a5e948334960)

-> 3번 예시
![image](https://github.com/ChaeYoonch/project502_13_2/assets/163954005/37e797ce-f15b-44ba-8b2e-bf0bfa3367e8)

4) Controller 는 Model 과 View 모두에 의존해도 Ok! (Controller 내부에 Model & View 코드 둘 다 가능)
![image](https://github.com/ChaeYoonch/project502_13_2/assets/163954005/ceff6992-1609-461e-9d9b-e150dc074bc5)

5) View 가 Model 에게서 데이터를 받을 때, 무조건 Controller 에서 받아야 함 (Model 에서 직접 X)
![image](https://github.com/ChaeYoonch/project502_13_2/assets/163954005/a0242bf4-1913-4dcd-a564-0de1f9289f71)
