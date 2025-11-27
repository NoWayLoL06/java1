# 권용준(202530102)

# (11월 27일 강의)

### 익명 클래스로 이벤트 리스너 작성
- 익명 클래스 (annoymous class): 이름 없는 클래스
  - 클래스 선언 + 인스턴스 생성을 한번에 달성

  - 간단한 리스너의 경우 익명 클래스 사용 추천
  - 메소드의 개수가 1, 2개인 리스너(AcrionListener, ItemListener)에 대해 주로 사용

### 어댑터 클래스
- 이벤트 리스너 구현에 따른 부담
  - 리스너의 추상 메소드를 모두 구현해야 하는 부담
  - 예) 마우스 리스너에서 마우스가 눌러지는 경우(mousePressed())만 처리하고자 하는 경우에도 나머지 4 개의 메소드를 모두 구현해야하는 부담

- 어댑터 클래스(Adapter)
  - 리스너의 모든 메소드를 단순 리턴하도록 만든 클래스(JDK에서 제공)
  - MouseAdapter 예
```java
class MouseAdapter implements MouseListener, MouseMotionListener, MouseWheelListener {
  public ...
}
```

### Key 이벤트와 포커스
- 키 입력시. 다음 세 경우 각각 Key 이벤트 발생
  - 키를 누르는 순간
  - 누른 키를 떼는 순간
  - 누른 키를 떼순간(Unicode의 경우에만)

- 키 이벤트를 받을 수 있는 조건
  - 모든 컴포넌트
  - 현재 포커스를 가진 컴포넌트가 키 이벤트 독점

- 포커스(focus)
  - 컴포넌트나 응용프로그램이 키 이벤트를 독점하는 권한
  - 컴포넌트에 포커스 설정 방법: 다음 2 라인 코드 필요
```java
component.setFocusable(true); 
component.requestFocus(); // component에 포커스 강제 지정
```

### KeyListener
- 응용프로그램에서 KeyListener를 상속받아 키 리스너 구현
- KeyListener의 3개 메소드
```java
void keyPressed(KeyEvent e){

}
void keyReleased(KeyEvent e){

}
void key?(KeyEvent e){

}
```

- 컴포넌트에 키 이벤트 리스너 달기

### 유니코드 키
- 유니코드 키의 특징
  - 국제 산업 표준
  - 전 세계의 문자를 컴퓨터에서 일관되게 표현하기 위한 코드 체계
  - 문자들에 대해서만 키 코드 값 정의: A~Z a~z 0~9 ! @ # 등

- 문자가 아닌 키 경우에는 표준화된 키 코드 값 없음
  - Fuction 키 Home 키 Up 키 등은 플랫폼에 따라 키 코드 값을 다를 수 있음

- 유니코드 키가 입력되는 경우

- 유니코드 키가 아닌 경우

### 가상 키와 입력된 키 판별
- keyEvent 객체
  - 입력된 키 정보를 가진 이벤트 객체
  KeyEvent 객체의 메소드로 입력된 키 판별

- KeyEvent 객체의 메소드로 입력된 키 판별
  - char KeyEvent.getKeychar()
  - 키의 유니코드 문자 값 리턴
  - Unicode 문자 키인 경우에만 의미 있음
  - 입력된 키를 판별하기 위해 문자 값과 비교하면 됨

- int KeyEvent.getKeyCode()
  - 유니코드 키 포함
  - 모든 키에 대한 정수형 키 코드 리턴
  - 입력된 키를 판별하기 위해 가상키 값과 비료하여야 함
  - 가상 키 값은 KeyEvent 클래스 상수로 선언

### 가상 키(virtual key)
- 가상 키는 KeyEvent 클래스에 상수로 선언

### Mouse 이벤트와 MouseListener, MouseMotionListener
- Mouse 이벤트: 사용자의 마우스 조직에 따라 발생하는 이벤트

- mouseCLicked(): 마우스가 눌러진 위치에서 그대로 뗴어질 때 호출
- mouseReleased(): 마우스가 눌러진 위치에서 그대로 떼어지든 아니든 항상 호출
- mouseDragged(): 마우스가 드래그되는 동안 계속 여러번 호출

- 마우스가 눌러진 위치에서 뗴어지는 경우 메소드 호출 순서

- 마우스가 드래그될 떄 호출되는 메소드 호출 순서

### 마우스 리스너 달기와 MouseEvent 객체 활용
- 마우스 리스너 달기
  - 마우스 리스너는 컴포넌트에 다음과 같이 등록

  - 컴포넌트가 마우스 무브나 마우스 드래깅을 함께 처리하고자 하면, MouseMotion 리스너 따로 등록

- MouseEvent 객체 활용
  - 마우스 포인터의 위치, 컴포넌트 내 상대 위치: int getX(), int getY()

- 마우스 클릭 횟수: int getClickCount()


# (11월 20일 강의)

### Swing 응용프로그램의 종료
- 응용 프로그램 내에서 스스로 종료하는 방법
  - 언제 어디서나 무조건 종료 System.exit(0);

- 프레임의 오른쪽 상단의 종료버튼(X)이 클릭되면 어떤 일이 일어나는가?
  - 프레임 종료, 프레임 윈도우를 닫음: 포레임이 화면에서 보이지 않게 됨

- 프레임이 보이지 않게 되지만 응용프로그램이 종료된 것이 아님.
  - 키보드나 마우스 입력 받지 못함
  - 다시 setVisible(true)를 호출하면, 보이게 되고 이전 처럼 작동함

- 프레임 종료버튼이 클릭될 때, 프레임과 함께 프로그램을 종료시키는 방법
```java
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
```

### 컨테이너와 배치, 배치관리자 개념
- 컨테이너의 배치관리자
  - 컨테이너마다 하나의 배치관리자 존재
  - 컨테이너에 부착되는 컴포넌트의 위치와 크기 결정
  - 컨테이너의 크기가 변경되면, 컴포넌트의 위치와 크기 재결정

### 배치 관리자 대표 유형 4가지
- FlowLayout 배치 관리자
  - 컴포넌트가 삽입되는 순서대로 왼쪽에서 오른쪽으로 배치
  - 배치할 공간이 없으면 아래로 내려와서 반복

- BorderLayout 배치 관리자
  - 컨테이너 공간을 동 서 남 북 중앙의 5가지 영역으로 나눔

- GridLayout 배치 관리자
  - 컨테이너를 프로그램에서 설정한 동일한 크기의 2차원 격자로 나눔
  - 컴포넌트는 삽입 순서대로 좌에서 우로, 다시 위에서 아래로 배치

- CardLayout

### 컨테이너와 디폴트 배치 관리자
  - 컨테이너의 디폴트 배치 관리자: 컨테이너 생성시 자동으로 생성되는 배치관리자
    - Windoww, JWindow    --> BorderLayout
    - Fream,   JFrame     --> BorderLayout
    - Dialog,  Jdialog    --> BorderLayout
    - Panel,   JPanel     --> FlowLayout

### 컨테이너에 새로운 배치관리자 설정
- 컨테이너에 새로운 배치관리자 설정
  - setLayout(LayoutManager lm) 메소드 호추리 lm을 새로운 배치관리자로 설정

- JPanel 컨테이너에 BorderLayout 배치관리자를 설정하는 예
  ```java
  JPanel p = new JPanel();
  p.setLayout(new BorderLayout()); // JPanel에 BorderLayout 설정
  ```

### FlowLayout 배치 관리자
- 배치 방법:
  - 컴포넌트를 컨테이너 내에 왼쪽에서 오른쪽으로 배칯
  - 다시 위에서 아래로 순서대로 배치

### FlowLayout의 생성자
- 생성자:
  - FlowLayout()
  - FlowLayout(int align, int hGap, int vGap)

- align: 컴포넌트를 정렬하는 방법 지정. 왼쪽 정렬(FlowLayout.LEFT), 오른쪽 정렬(FlowLayout.RIGHT), 중앙 정렬(FlowLayout.SENTER)

### BorderLayout 배치 관리자
- 배치 방법:
  - 컨테이너 공간을 5 구역으롭 분할, 배치: 동, 서, 남, 북, 중앙

- 배치 방법:
  - add(Component comp, int index): comp를 index의 공간에 배치

### BorderLayout 생성자와 add() 메소드
- 생성자
  - BorderLayout()
  - BorderLayout(int hGap, int vGap)
    - hGap: 좌우 두 컴포넌트 사이의 수평 간격, 픽셀 단위(디폴트: 0)
    - VGap: 상하 두 컴포넌트 사이의 수평 간격, 픽셀 단위(디폴트: 0)

### GridLayout 배치 관리자
- 배치 방법
  - 컨테이너 공간을 동일 사각형 격자(그리드)로 분할하고 각 셀에 컴포넌트 하나씩 배치
  - 생성자에 행수와 열수 지정
  - 셀에 왼쪽에서 오른쪽으로, 다시 위에서 아래로 순서대로 배치
```java

```
### GirdLayout 생성자
- 생성자
  - GridLayout()
  - GridLayout(int rows, int cols)
  - GridLayout(int rows, int cols, int hGap, int vGap)
    - rows: 격자의 행수 디폴트 1
    - cols: 격자의 행수 디폴트 1
    - hGap: 좌우 두 컴포넌트 사이의 수평 간격, 픽셀 단위(디폴트: 0)
    - VGap: 상하 두 컴포넌트 사이의 수평 간격, 픽셀 단위(디폴트: 0)

### 배치 관리자가 없는 컨테이너
- 배치관리자가 없는 컨테이너가 필요한 경우
  - 응용프로그램에서 직접 컴포넌트의 크기와 위치를 결정하고자 하는 경우
  1. 컴포넌트의 크기나 위치를 개발자 임의로 결정하고자 하는 경우
  2. 게임 프로그램과 같이 시간이나 마우스/키보드의 입력에 따라 컴포넌트들의 위치와 크기가 수시로 변하는 경우
  3. 여러 컴포넌트들이 서로 겹쳐 출력하고자 하는 경우

### 컴포넌트의 절대 위치와 크기 설정
- 배치 관리자가 없는 컨테이너에 컴포넌트를 삽입할 떄
  - 프로그램에서 컴포넌트의 절대 크기와 위치 설정
  - 컴포넌트들이 서로 겹치게 할 수 있음

- 컴포넌트의 크기와 위치 설정 메소드
  - void setSize(int width, int height) // 컴포넌트 크기 설정
  - void setLocation(int x, int y) // 컴포넌트 위치 설정
  - void setBounds(int x, int y, int width, int height) // 위치와 크기 동시 설정

- 예 버튼을 100x40 크기로 하고, JPanel의 (50,50) 위치에 배치
```java
JPanel p = new JPanel();
p.setLayout(null)

JButton clickBtton = new Jbutton("Click");
clickButton.setSize(100, 40);
clickButton.setLocation(50,50);
p.add(clickButton);
```
### 이벤트 기반 프로그래밍
- 이벤트 기반 프로그래밍(Event Driven Programming)
  - 이벤트의 발생에 의해 프로그램 흐름이 결정되는 방식
    - 이벤트가 발생하면 이벤트를 처리하는 루틴(이벤트 리스너) 실행
    - 실행될 코드는 이벤트의 발생에 의해 전적으로 결정

  - 반대되는 개념: 배치 실행(batch programming)
    - 프로그램의 개발자가 프로그램의 흐름을 결정하는 방식
  
  - 이벤트 종류
    - 사용자의 입력: 마우스 드래그, 마우스 클릭, 키보드 누름
    - 센서로부터의 입력, 네트워크로부터 데이토 송수신
    - 다른 응용프로그램이나 다른 스레드로부터의 메시지
  
  - 이벤트 기반 응용 프로그램의 구조
    - 이벤트마다 처리하는 리스너 코드 보유
  
  - GUI 응용프로그램은 이벤트 기반 프로그래밍으로 작성됨
    - GUI 라이브러리 종류: C++의 MFC, C# HUI, Visual Basic, X Window, Android
    - 자바의 AWT와 Swing

### 이벤트 객체
- 이벤트 객체
  - 발생한 이벤트에 관한 정보를 가진 객체
  - 이벤트 리스너에 전달됨
    - 이벤트 리스너 코드가 발생한 이벤트에 대한 상황을 파악할 수 있게 함

- 이벤트 객체가 포함하는 정보

# (11월 13일 강의)

### toString() 메소드, 객체를 문자열로 변환
- 각 클래스는 toString()을 오버라이딩하여 자신만의 문자열 리턴 가능
  - 객체를 문자열로 변환
  - 원형 : public String toString();

### 객체 비교(==)와 equals() 메소드
- == 연산자: 객체 레퍼런스 비교

- boolean equals(Object obj)
  - 두 객체의 내용물 비교
```java
Point a = new Point(2,3);
Point b = new Point(2,3);
Point c = a;

if(a == b) // false
  System.out.println("a==b");
if(a == c) // true
  System.out.println("a==c");

```

  - 객체의 내용물을 비교핳기 위해 클래스의 멤버로 작성

### Wrapper 클래스
- wrapper 클래스: 자바의 기본 타입을 클래스화 한 8개 클래스의 통칭
  - 용도: 객체만 사용할 수 있는 컬렉션 등에 기본 타입의 값을 사용하기 위해 Wrapper 객체로 만들어 사용한다.

### Wrapper 객체 생성
- 기본 타입의 갑승로 Wrapper 객체 생성
```java
integer i = integer.valueOf(10);
Chracter c = Chracter.valueOf('c');
Double f = Double.valueOf(3.14);
```

- 문자열로 Wrapper 객체 생성
```java
int i = integer.parseint("123"); // i = 123
```

- Float 객체는 double 타입의 값으로 생성 가능
```java
String s1 = integertoString(123); // 정수 123을 문자열 "123"으로 변환
```

### 박싱과 언박싱
- 박싱(boxing): 기본 타입의 값을 Wrapper 객체로 변환하는 것.

- 언박싱(unboxing): Wrapper 객체에 들어 있는 기본 타입의 값을 뺴내는 것. 박싱의 반대
```java
Integer ten = Integer.valueOf(10); // 박싱
int n = ten.inValue(); // 언박싱
```
- 자동 박싱과 자동 언박싱: JDK 1.5부터 박싱과 언박싱은 자동으로 이루어짐 

### String의 생성과 특징
- String 클래스는 문자열을 나타냄

- 스트링 리터럴(문자열 리터럴)은 String 객체로 처리됨

- 스트링 객체의 생성 사례
```java
String str1 = "abcd"

char data[] = {'a','b','c','d'}
String str2 = new String(data);
String str3 = new String("abcd"); // str2와 str3는 모두 "abcd" 문자열
```

### 스트링 리터럴과 new String()
- 스트링 리터럴
  - 자바 가상 기계 내부에서 리터럴 테이블에 저장되고 관리됨
  - 응용프로그램에서 공유됨
  - 스트링 리터럴 사례) String s = "hello";

- new String() 으로 생성된 스트링
  - 스트링 객체는 힙에 생성
  - 스트링은 공유되지 않음

### 스트링 객체의 주요 특징
- 스트링 객체는 수정 불가능
  - 리터럴 스트링이든 new String()을 생성했든 객체의 문자열은 수정 불가능


- 스트링 비교: 두 스트링을 비교할 때 반드시 equals()를 사용하여야 함 --> equals()는 내용을 비교하기 때문

### String 활용
- 스트링 비교, equals()와 compareTo()
  - --> 스트링 비교에 == 연산자 절대 금지
  - equals(): 스트링이 같으면 true, 아니면 false 리턴
```java
String java = "java"
if(java.equals("java")) // true
```

- int compareTo(String anotherString)
  - 문자열이 같으면 0 리턴
  - 이 문자열이 anotherString 보다 먼저 나오면 음수 리턴
  - 이 문자열이 anotherString 보다 나중에 나오면 양수 리턴
```java
String java = "Java"
String cpp = "C++"
int res = java.compareTo(cpp);
if(res == 0) System.out.println("the same");
else if(res < 0) System.out.println(java + " < " + cpp);
else System.out.println(java + " > " + cpp);
```

### 자바의 GUI(Graphical User Interface)
- GUI: 사용자가 편리하게 입출력을 할 수 있도록 그래픽으로 화면을 구성하고 마우스나 키보드로 입력 받을 수 있도록 지원하는 인터페이스

- 자바 언어에서 GUI 응용프로그램 작성: AWT와 Swing 패키지에 강력한 GUI 컴포넌트 제공.

- AWT 패키지
  - 자바가 처음 나왔을 때 배포된 GUI 패키지, 최근에는 사용하지 않음
  - AWT 컴포넌트는 중량 컴포넌트
  - AWT 컴포넌트의 그리기는 운영체제에 의해 이루어지며, 운영체제에 자원을 많이 소모하고 부담을 줌
  - 운영체제가 직접 그리기에 속도는 빠르다.

- Swing 패키지
  - AWT 기술을 기반으로 작성된 자바 라이브러리
  - 모든 AWT 기능 추가된 풀부하고 화려한 고급 컴포넌트
  - AWT 컴포넌트를 모두 스윙으로 재 작성
  - AWT 컴포넌트의 이름 앞에 J자를 덧붙임
  - 순수 자바 언어로 구현
  - 스윙 컴포넌트는 경량 컴포넌트
  - 스윙 컴포넌트는 운영체제의 도움을 받지 않고, 직접 그리기 때문에 운영체제에 부담을 주지 않음
  - 현재 자바의 GUI 표준으로 사용됨

### 컨테이너와 컴포넌트
- 컨테이너
  - 다른 컴포넌트를 포함할 수 있는 GUI 컴포넌트: java.awt.Container를 상속받음
  - AWT 컨테이너: Panel, Frame, Applet, Dialog, Window
  - Swing 컨테이너: JPanel JFrame, JApplet, JDialog, JWindow

- 컴포넌트
  - 컨테이너에 포함되어야 화면에 출력될 수 있는 GUI 객체
  - 다른 컴포넌트를 포함할 수 없는 순수 컴포넌트
  - 모든 GUI 컴포넌트가 상속받는 클래스: java.awt.Component
  - 스윙 컴포넌트가 상속받는 클래스: java.swing.Jcomponent

- 최상위 컨테이너
  - 다른 컨테이너에 포함되지 않고도 화면에 출력되며, 독립적으로 존재 가능한 컨테이너
  - 스스로 화면에 자신을 출력하는 컨테이너: JFrame, JDialog,g JApplet

### Swing GUI 프로그램 만들기
- 스윙 GUI 프로그램을 만드는 과정
1. 스윙 프레임 만들기
2. main() 메소드 작성
3. 스윙 프레임에 스윙 컴포넌트 붙이기

### Swing 프레임
- 스윙 프레임: 모든 스윙 컴포넌트를 담는 최상위 컨테이너
  - JFrame을 상속받아 구현
  - 컴포넌트들은 화면에 보이려연 스윙 프레임에 부착되어야 함
  - 프레임을 닫으면 프레임에 부착된 모든 컴포넌트가 보이지 않게 됨

- 스윙 프레임 기본 구성
  - 프레임: 스윙 프로그램의 기본 틀
  - 메뉴바: 메뉴들이 부착되는 공간
  - 컨텐트팬: GUI 컴포넌트들이 부착되는 공간

### 프레임 만들기, JFrame 클래스 상속
- 스윙 프레임
  - JFrame 클래스를 상속받은 클래스 작성
  - 프레임의 크기 반드시 지정: setSize() 호출
  - 프레임을 화면에 출력하는 코드 반드시 필요: setVisible(true) 호출
```java
import javax.swing.*;

public class MyFrame extends JFrame {
  public MyFrame() {
    setTitle("300x300 스윙 프레임 만들기");
    setSize(300,300);
    setVisible(true);
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new MyFrame();
      }
    });
  }
}
```
### Swing 응용프로그램에서 main()의 기능과 위치
- 스윙 응용프로그램에서 main()의 기능 최소화 바람직
  - 스윙 응용프로그램이 실행되는 시작점으로서의 기능만
  - 스윙 프레임을 생성하는 정도의 코드로 최소화
```java
public static void main(String[] arg) {
  MyFrame frame = new MyFrame(); // 스윙 프레임 생성
}
```

### 프레임에 컴포넌트 붑이기
- 타이틑 닳기
  - super() 나 setTitle() 이용

### Tip. 컨텐트팬에 대한 JDK 1.5 이후의 추가 사항
- JDK 1.5 이전
  - 프레임의 컨텐트팬을 알아내서, 반드시 컨텐트팬에 컴포넌트 부착

- JDK 1.5 이후
  - 프레임에 컴포넌트를 부착하면 프레임이 대신 컨텐트팬에 부착

- 결론
  - JDK 1.5 이전처럼 직접 컨텐트팬에 컴포넌트를 부착하는 것이 바람직함
  - 컨텐트팬 다루기 능력 필요하기 때문
  - 컨포넌트의 부모가 프레임이 아닌, 컨텐트팬임을 알고 명확히 사용할 필요

# (11월 6일 강의)

### 패키지 개념과 필요성
- 3명이 분담하여 자바 응용프로그램을 개발하는 경우
  - 동일한 이름의 클래스가 존재할 가능성 있음
  - 오류의 가능성
- 개발자가 서로 다른 디렉터리로 코드 관리

### 자바의 패키지와 모듈이란
- 패키지
  - 서로 관련된 클래스와 인터페이스를 컴파일한 클래스 파일들을 묵어 놓은 디렉터리
  - 하나의 응용프로그램은 한 개 이상의 패키지로 작성
  - 패키지는 jar 파일로 압축할 수 있음

- 모듈
  - 여러 패키지와 이미지 등의 자원을 모아 놓은 컨테이너
  - 하나의 모듈을 하나의 .jamod 파일에 저장

- Java 9부터 모듈화 도입
  - 플랫폼의 모듈화: Java 9부터 자바 API의 모든 클래스들(자바 실행 환경)을 패키지 기반에서 모듈들로 완전히 재구성
  
- 응용프로그램의 모듈화: 클래스들은 패키지로 만들고, 다시 패키지를 모듈로 만듦 ----- 모듈은 프로그래밍은 어렵고 복잡하다.

### 자바의 모듈화의 목적
- 모듈화의 목적
  - Java 9부터 자바 API를 여러 모듈(99)개로 분활: Java 8까지는 rt.jar의 한 파일에 모든 API 저장. # 현재는 70개로 정리
  - 응용프로그램이 실행될 때 꼭 필요한 모듈들로만 실행 환경 구축: 메모리 자원이 열약한 작은 소형 기기에 꼭 필요한 모듈로 구성된 작은 크기에 실행 이미지를 만들기 위함

### 자바 API의 모듈 파일들
- 자바 JDK에 제공되는 모듈 파일들
  - 자바가 설치된 jmods 디렉터리에 모듈 파일 존재: .jomd 확장자를 가진 파일. 모듈은 수 십개. 모듈 파일은 ZIP 포맷으로 압축된 파일. -> # 포맷이 zip이며, 확장자는 .jomd입니다

### 패키지 사용하기, import문
- 다른 패키지에 작성된 클래스 사용
  - import를 이용하지 않는 경우
  - -> 소스에 클래스 이름의 완전명 사용
```java
public class ImportExample {
  public static void main(String[] args) {
    java.util.Scanner scanner =
      new java.util.Scanner(System.in);
  }
}
```
- 필요한 클래스판 import
  - 소스 스작 부분에 클래스의 경로명 import
  - import 패키지, 클래스
  - 소스에는 클래스 명만 명시하면 됨

- 패키지 전체를 import 
  - 소스 시작 부분에 패키지의 경로명
  - import 패키지
  - 소스에는 클래스 명만 명시하면 됨
  - import java.util
  - -> java.util 패키지 내의 모든 클래스만을 지정, 하위 패키지의 클래스는 포함하지 않음

### 패키지 만들기
- 클래스 파일(.class)이 저장되는 위치는?
  - 클래스나 인터페이스가 컴파일 되면 클래스 파일(.class) 생성
  - 클래스 파일은 패키지로 선언된 디렉터리에 저장됨

- 패키지 선언
  - 소스 파일의 맨 앞에 컴파일 이후 저장될 패키지 지정
```java
package UI;

public class Tools {
  .....
}
```

```java
package Graphic;

import UI.tools;

public calss Line extends Shape {
  public void draw() {
    Toos t = new Toos();
  }
}
```

### 디폴트 패키지
- package 선언문이 없는 자바 소스 파일의 경우
  - 컴파일러는 클래스나 인터페이스를 디폴트 패키지에 소속ㄱ시킴
  - 디폴트 패키지 --> 현재 디렉터리

### package의 운영 방법
- 패키지 이름은 도메인 기반으로 시작 형식: com.회사이름,프로젝트명.기능명
  - -> 충돌 방짖
- 기능/역할별로 하위 패키지를 구분: utils, controller, service 등

- 디렉토리 구조와 package 선언을 정확히 일치해야 합니다.

- import는 필요한 만큼만, * 전체 import는 피하는 것이 좋습니다.

### 모듈 개념
- Java 9에서 도입된 개념

- 패키지와 이미지 등의 리소스를 담은 컨테이너

- 모듈 파일(.jmod)저장

### 자바 플랫폼읭 모듈화

- 자바 플랫폼
  - 자바의 개발 환경(JDK)과 자바의 실행 환경(JRE)을 지칭, Java SE(자바 API) 포함

  - 자바 API의 모든 클래스가 여러 개의 모듈로 재구성됨
  
  - 모듈 파일은 JDK의 jmods 디렉터리에 저장하여 배포

### 자바 모듈화의 목적
- 자바 컴포넌트들을 필요해 따라 조립하여 사용하기 위함

- 컴퓨터 시스템의 불필요한 부담 감소
  - 세밀한 모듈화를 통해 필요 없는 모듈이 로드되지 않게 함
  - 소형 IoT 장치에도 자바 응용프로그램들 사용됨

### JDK의 주요 패키지
- java.lang
  - 스트링, 수학 함수, 입출력 등 자바 프로그래밍에 필요한 기본적인 클래스와 인터페이스

- java.uill
  - 날짜, 시간, 벡터, 헤시맵 등과 같은 다양한 유틸리티 클래스와 인터페이스 제공

- java.io
  - 키보드, 모니터, 프린터, 디스크 등에 입출력을 할 수 있는 클래스와 인터페이스 제공

- java.awt
  - GUI 프로그램을 작성하기 위한 AWT프로그램

- javax.swing

### Object 클래스

### 객체 속성
- Object 클래스는 객체의 속성을 나타내는 메소드 제공

- hashCode() 메소드
  - 객체의 헤시코드 값을 리턴하며, 객체마다 다름

- getClass() 메소드
  - 객체의 클래스 정보를 담은 Class 객체 리턴
  - Class 객체의 getName() 메소드는 객체의 클래스 이름 리턴

- toString() 메소드
  - 객체를 문자열로 리턴함.

# ( 10월 31일 강의)

### 다운 캐스팅(dowdcasting)
- 슈퍼클래스 레퍼런스를 서브 클래스 레퍼런스에 업캐스팅 된 것을 다시 원래대로 되돌리는 것

- 반드시 명시적 타입 변환 지정
```java
class Person{}
class Student extends Person{}

Person p = new Student("이재문"); // 업캐스팅

Student s = (Student)p; // 다운 캐스팅
```

### 업캐스팅 레퍼런스로 객체 구별?
- 업캐스팅된 레퍼런스로는 객체의 실제 타입을 구분하기 어려움

- 슈퍼 클래스는 여러 서브 클래스에 상속되기 때문

- 예를 들어 아래의 클래스 계층 구조에서, p가 가리키는 객체가 Person 객체인지, Student 객체인지, Professor 객체인지 구분 어려움

```java
Person p = new Person();
Person p = new Student(); // 업캐스팅
Person p = new Professor(); // 업캐스팅
```

### instanceof 연산자 사용
- 레퍼런스가 가리키는 객체의 타입 식별: 연산의 결과는 true/false의 불린 값으로 반환

- instanceof 연산자 사용 사례
```java
Person p = new Professor();
if(p instanceof Person) // true
if(p instanceof Student)  // false, student를 상속 X
if(p instanceof Researcher) // true
if(p instanceof Professor)  // ture
```

### 메소드 오버라이딩(Method Overriding)의 개념
- 서브 클래스에서 슈퍼 클래스의 메소드 중복 작성

- 슈퍼 클래스의 메소드 무력화, 항상 서브 클래스에 오버라이딩한 메소드가 실행되도록 보장

- "메소드 무시하기"로 번역되기도 함

- 오버라이딩 조건
 - -> 슈퍼 클래스 메소드의 원형(메소드 이름, 인자 타입 및 개수, 리턴 타입) 동일하게 작성

 ### 서브 클래스 객체와 오버라이딩된 메소드 호출
 - 오버라이딩 한 메소드가 실행됨을 보장
 ```java
 class A {
  void f() {
    System.out.println("A의 f()호출");
  }
 }
 class B extends A {
  void f() {  // 클래스의 A의 f()를 오버라이딩
    System.out.println("A의 f()호출");
  }
 }
 ```

### 오버라이딩의 목적, 다향성 실현
- 오버라이딩으로 다형성 실현

- 하나의 인터페이스(같은 이름)에 서로 다른 구현

- 슈퍼 클래스의 메소드를 서브 클래스에서 각각 목적에 맞게 다르게 구현

- 사례: Shape의 draw() 메소드를 Line, Rect, Circle에서 오버라이딩하여 다르게 구현

### 동적 바인딩 - 오버라이딩된 메소드 호출
- SuperObject 하나만 있는 응용프로그램의 경우 혹은 상속받은 경우 모두 동적 바인딩을 한다.

- 오버라이딩 메소도가 항상 호출된다
  - SuperObject는 키워드가 아님

```java
public class SuperObject {
  protected String name;
  public void paint() {
    draw();
  }
  public void draw() {
    System.out.println("Super Object");
  }
  public static void main(String[] args) {
    SuperObject a = new SuperObject();
    a.paint();
  }
}
```
### super 키워드로 슈퍼 클래스의 멤버 접근
- 슈퍼 클래스의 멤버를 접근할 때 사용되는 레퍼런스
  - super.슈퍼클래스의 멤버

- 서브 클래스에서만 사용

- 슈퍼 클래스의 필드 접근

- 수퍼 클래스의 메소드 호출 시 super로 이루어지는 메소드 호출: 정적 바인딩

### 추상 클래스
- 추상 메소드 (abstract method)
  - abstract로 선언된 메소드, 메소드의 코드는 없고 원형만 선언
```java
// 추상 메소드를 가진 추상 클래스
abstract public String getName(); // 추상 메소드
```

- 추상 클래스
  - 추상 메소드를 가지며 abstract로 선언된 클래스
  - 추상 메소드 없이, abstract로 선언된 클래스

```java
// 추상 메소드를 가진 추상 클래스
abstract class Shape {
  public Shape() {...}
  public edit() {...}

  abstract public void draw(); // 추상 클래스
}
```
```java
// 추상 메소드 없는 추상 클래스
abstract class JComponent {
  String name;
  public void load(String name ) {
    this.name = name;
  }
}
```

### 추상 클래스의 인스턴스 생성 불가
- 추상 클래스는 온전한 클래스가 아니기 떄문에 인스턴스를 생성할 수 없음

### 추상 클래스의 상속과 구현
- 추상 클래스 상속
  - 추상 클래스를 상속 받으면 추상 클래스됨
  - 서브 클래스도 abstract로 선언 해야 함
```java
abstract class A { // 추상 클래스
  abstract public int add(int x, int y); // 추상 메소드
}
abstract class B extends A { // 추상 클래스
  public void show() { System.out.println("B"); }
}
```
- 추상 클래스 구현
  - 서브 클래스에서 슈퍼 클래스의 추상 메소드 구현 (오버라이딩)
  - 추상 클래스를 구현한 서브 클래스는 추상 클래스 아님(?)
```java
class C extends A { // 추싱 클래스 구현, C는 정상 클래스
  public int add(int x, int y) { return x+y;} // 추상 메소드 구현, 오버라이딩
  public void show() { System.out.println("c");}
  ...
  C c = newC{}; // 정상
}
```

### 추상 클래스 목적
- 상속을 위한 슈퍼 클래스로 활용하는 것
- 서브 클래스에서 추상 메소드구현
- 다향성 실현

### 자바의 인터페이스
- 소프트웨어를 규격화된 모듈로 만들고, 인터페이스가 있는 모듈을 조립하듯이 응용프로그램을 작성 하기위해서 사용.

- 자바의 인터페이스
  - 클래스가 구현해야 할 메소드들이 선언되는 추상형
  - 인터페이스 선언: interface 키워드로 선언. Ex) public interface SerialDriver???

```java
interface PhoneInterface {
  public static final int TIMEOUT = 10000;
  public abstract void sendCall();
  public abstract void receiveCall();
  public default void printLogo() {
    System.out.println("** Phone **")
  }
}
```

### 인터페이스 구성 요소들의 특징
- 상수: public만 허용, public static final 생략

- 추상 메소드: public static 생략

- default 메소드:
  - 인터페이스에 코드가 작성한 메소드
  - 인터페이스를 구현하는 클래스에 자동 상속
  - public 접근 지정만 허용, 생략 가능

- private 메소드:
  - 인터페이스 내에 메소드 코드가 작성되어야 함
  - 인터페이스 내에 있는 다른 메소드에 의해서만 호출 가능

- static 메소드: public, private 둘 다 허용

### 자바 인터페이스 특징
- 인터페이스의 객체 생성 불가
```java
new PhoneInterface(); // 오류 인터페이스 PhoneInterface 객체 생성 불가
```

- 인터페이스 타입의 레퍼런스 변수 선언 가능
```java
PhoneInterface galaxy; // galaxy는 언터페이스에 대한 레퍼런스 변수
```

### 인터페이스 상속
- 인터페이스 간의 상속 가능:
  - 인터페이스를 상속하여 확장된 인터페이스 작성 가능
  - extends 키워드 상속
  - 다중 상속 허용

### 인터페이스 구현
- 인터페이스의 추상 메소드를 모두 구현한 클래스 작성
  - implements 키워드 사용
  - 여러 개의 인터페이스 동시 구현 가능

# ( 10월 30일 강의)

### 객체 지향 상속의 필요성
- 상속이 없는 경우 중복된 멤버를 가짐

- 상속이 있는 경우 중복이 제거되고 간결해짐

### 클래스 상속과 객체
- 선언 : extends 키워드

- 부모 클래스를 물려받아 자식 클래스를 확장의 의미

- 부모 클래스 --> 슈퍼 클래스

- 자식 클래스 --> 서브 클래슷
``` java
class Point {
  int x, y;
}
class ColorPoint extends Point{ // Point를 상속 받음
}
```

### 서브 클래스 객체의 모양
- 슈퍼 클래스 객체와 서브 클래스의 객체는 별개

- 서브 클래스 객체는 슈퍼 클래스 멤버에 포함

### 상속 특징
- 클래스 다중 상속 불허
  - 하나의 클래스 둘 이상의 부모 클래스를 동시에 받는 것

- C++은 다중 상속 가능
- C++은 다중 상속으로 멤버가 중복 생성되는 문제 있음.
  - 부모 클래스 간에 계층적 관계가 있으면, 중복된 멤버가 생설 될 수 있음
  - 모호성의 문제: 두 부모 클래스에 동일한 이름의 멤버가 존재하면 어떤 부모의 멤버를 호출할지 모호해짐

- 자바는 인터페이스의 다중 상속 가능

- 모든 자바 클래스는 묵기적으로 object클래스 상속
  - java.lang.object는 모든 클래스의 슈퍼 클래스

### 슈퍼 클래스의 멥버에 대한 서브 클래스의 접근
- 슈퍼 클래스의 private 멤버: 서브 클래스 접근 불가

- 슈퍼 클래스의 디폴트 멤버: 서브 클래스가 동일 패키지가 있을 때, 가능

- 슈퍼 클래스의 public 멤버: 항상 가능

- 슈퍼 클래싕 protected 멤버: 같은 패키지 내의 모든 클래스 접근 가능

### 서브/슈퍼 클래스의 생성자 호출과 실행
- 서브 클래스의 객체가 생성될 때: 서브/슈퍼 클래스 생성자 모두 실행

- 호출 순서: 서브 --> 슈퍼 클래스 생성자 호출

- 실행 순서: 슈퍼 --> 서브 클래스 생성자 실행

### 서브 클래스와 슈퍼 클래스의 생성자 선택
- 슈퍼/서브 클래스: 여러 개의 생성자 작성 가능

- 서브 클래스의 객체가 생성될 때: 슈퍼 클래스 1개 서브 클래스 1개의 생성자가 실행

- 서브 클래스의 생성자와 슈퍼 클래스의 생성자가 결정되는 방식

1. 개발자의 명시적 선택
  - 서브 클래스 개발자가 슈퍼 클래스의 생성자 명시적 선택
  - super() 키워드 사용

2. 컴파일러가 기본 생성자 선택
  - 서브 클래스 개발자가 슈퍼 클래스의 생성자를 선택하지 않는 경우
  - 컴파일러가 자동으로 슈퍼 클래스의 기본 생성자 선택

### 컴파일러에 의해 슈퍼 클래스의 기본 생성자가 묵시적 선택(1)
``` java
class A {
  public A() {
    System.out.println("생성자A");
  }
  public A(int x) {
    ....
  }
}
```
``` java
class B extends A {
  public B() {
    System.out.println("생성자B");
  }
}
```
``` java
public class ConstructorEx2 {
  public static void main(Sting[] args) {
    B b;
    b = new B(); // 생성자 호출
  }
}
```

### 서브 클래스의 매개 변수를 가진 생성자에 대해서도 슈퍼 클래스의 기본 생성자가 자동 선택
``` java
class A {
  public A() {
    System.out.println("생성자A");
  }
  public A(int x) {
    System.out.println("매개변수생성자A");
  }
}
```
``` java
class B extends A {
  public B() {
    System.out.println("생성자B");
  }
}
```
``` java
public class ConstructorEx2 {
  public static void main(Sting[] args) {
    B b;
    b = new B(5); // 생성자 호출
  }
}
```

### super()로 슈퍼 클래스의 생성자 명시적 선택
- super(): 서브 클래스에서 명시적으로 슈퍼 클래스 생성자 선택 호출

- 사용 방식
  - super(parameter);
  - 인자를 이용하여 슈퍼 클래스의 적당한 생성자 호출
  - 반드시 서브 클래스 생성자 코드의 제일 첫 라인에 와야 함.

### 업캐스팅(upcasting) 개념
- 하위 클래스의 레퍼런스는 상위 클래스를 가리킬 수 없다 
- 상위 클래스의 레퍼런스는 하위 클래스를 가리킬 수 있다

### 업캐스팅
- 생물이 들어가는 박스에 사람이나 코끼리를 넣어도 무방.
- 사람이나 코끼리 모두 생물이라는 상속 받았기 때문

- 업캐스팅 이란?
  - 서브 클래스의 레퍼런스를 슈퍼 클래스 레퍼런스에 대입
  - 슈퍼 클래스 레퍼런스로 서브 클래스 객체를 가리키게 되는 현상

  ```java
  class Person {}
  class Student extends Person {}

  person p;
  Student s = new Student();
  p = s; // 업캐스팅
  ```

### 업캐스팅 사례
```java
class Person{
  String name;
  String id;

  public Person(String name) {
    this.name = name;
  }
}
class Student extends Person {
  String grade;
  String department;

  public Student(String name) {
    super(name);
  }
}
public class UpcastingEx {
  public static void main(String[] args) {
    Person p;
    Student s = new Student("이재문");
    p = s;

    System.out.println(p.name); // 오류 없음

    p.grade = "A"; // 컴파일 오류
    p.department = "Com"; // 컴파일 오류
  }
}
```

### static 메소드의 제약 조건 1
- static 메소드는 오직 static 멤버만 접근 가능
  - 객체가 생성되지 않은 상황에서도 static 메소드는 실행될 수 있기 때문
  - non-static멤버도 사용가능

### static 메소드의 제약 조건 2
- this(레퍼런스) 시용 불가

- 객체 없이도 사용 가능 

### final 클래스와 메소드
- final 클래스 - 더 이상 값 변환 불 가능

### final 필드
- 상수를 선언할 때 사용

# ( 10월 23일 강의)

### 클래스와 객체
- 실 세계 객체의 특징
  - 객체마다 고유헌 특성(state)와 행동(behavior)를 가짐
  - 다른 객체들과 상호작용하면서 살아감

- 컴퓨터 프로그램에서 객체 사례
  - 테트리스 게임의 각 블록들
  - 한글 프로그램의 메뉴나 버튼들

### 객체 지향 특성 : 캡슐화
- 캡슐화: 객체를 캡슐로 싸서 내부를 볼 수 없게 하는 것
  - 객체의 가장 본질적인 특징
  - 외부의 접근으로부터 객체 보호

- 자바의 캡슐화
  - 클래스(class): 객체 모양을 선언한 틀(캡슐화하는 틀)
  - 객체: 생성된 실체(instance): 클래스 내에 메소드와 필드 구현

### 객체 지향 특성 : 상속
- 상속
  - 상위 객체의 속성이 하위 객체에 물려 줌
  - 하위 객체가 상위 객체의 속성을 모두 가지는 관계

- 실세계의 상속 사례
  - 나무는 식물의 속성과 생물의 속성을 모두 가짐
  - 사람은 생물의 속성을 가지지만 식물의 속성은 가지고 있지 않음

### 자바의 상속
- 자바의 상속
  - 상위 클래스의 멤버를 하위 클래스 물려 받음
  - 상위 클래스: 수퍼 클래스
  - 하위 클래스: 서브 클래스, 수퍼 클래스 코드의 재사용, 새로운 특성 추가 가능

### 객체 지향 특성 : 다형성
- 다형성
  - 같은 이름의 메소드가 클래스 혹은 객체에 따라 다르게 구현되는 것

- 다형성 사례
  - 메소드 오버로딩: 한 클래스 내에서 같은 이름이지만 다르게 작동하는 여러 메소드
  - 메소드 오버라이딩: 수퍼 클래스의 메소드를 동일한 이름으로 서브 클래스마다 다르게 구현

### 객체 지향 언어의 목적
1. 소프트웨어의 생산성 향상
- 컴퓨터 산업 발전에 따라 소프트웨어의 생명 주기(Life cycle) 단축
  - 소프트웨어를 빠른 속도로 생산할 필요성 중대

- 객체 지향 언어
  - 상속, 다향성, 객체, 캡슐화 등 소프트웨어 재사용을 위한 여러 장치 내장
  - 소프트웨어 재사용과 부분 수정 빠름
  - 소프트웨어를 다시 만드는 부담 대폭 줄임
  - 소프트웨어 생산성 향상

2. 실세계에 대한 쉬운 모델링
- 초기 프로그래밍
  - 수학 계산.통계 처리를 하는 등 처리 과정, 계산 절차 중요

- 현대 프로그래밍
  - 컴퓨터가 산업 전반에 활용
  - 실세계에서 발생하는 일을 프로그래밍
  - 실세계에서는 절차나 과정보다 물체(객체)들의 상호 작용으로 묘사하는 것이 용이

- 객체 지향 언어
  - 실세계의 일을 보다 쉽게 프로그래밍하기 위한 객체 중심적 언어

### 절자 지향 프로그래밍과 객체 지향 프로그래밍
- 절차 지향 프로그래밍
  - 작업 순서를 표한하는 컴퓨터 명령 집합
  - 함수들의 집합으로 프로그램 작성

- 객체 지향 프로그래밍
  - 컴퓨터가 수행하는 작업을 객체들 간의 상호 작용으로 표현
  - 클래스 혹은 객체들의 집합으로 프로그램 작성

 ### 클래스와 객체
 - 클래스: 객체의 속성(state)과 행위(behavior) 선언, 객체의 설계도 혹은 틀.

 - 객체: 클래스의 틀로 찍어낸 실체
  - 프로그램 실행 중에 생성되는 실페
  - 메모리 공간을 갖는 구체적인 실체
  - 인스턴스(instance)라고도 부름

- 사례
  - 클래스: 소나타 자동차, 객체: 출고된 실제 소나타 100대

### 자바 클래스 구성
- 클래스
  - class 키워드로 선언
  - 멤버: 클래스 구성 요소. 필드(멤버 변수)와 메소드(멤버 한수)
  - 클래스에 대한 public 접근 지정: 다른 모든 클래스에서 클래스 사용 허락
  - 멤버에 대한 public 접근 지정: 다른 모든 클래스에게 멤버 접근 허용

### 생성자의 특징
- 생성자 이름은 클래스 이름과 동일

- 생성자는 여러 개 작성 가능(생성자 중복)

- 생성자는 객체 생성시 한 번만 호출

- 생성자의 목적은 객체 생성 시 초기화

- 생성자는 리턴 타입을 지정할 수 없음

### 생성자의 종류
- 기본 생성자(default constuctor): 매개 변수 없고, 아무 작업 없이 단순 리턴하는 생성자

- 기본 생성자가 자동 생성되는 경우
  - 클래스에 생성자가 하나도 선언되어 있지 않을 때
  - 컴파일러에 의해 기본 생성자 자동 생성

- 기본 생성자가 자동 생성되지 않은 경우
  - 클래스에 생성자가 선언되어 있는 경우
  - 컴파일러는 기본 생성자를 자동 생성해주지 않는다

### this 레퍼런스
- 객체 자신에 대한 레퍼런스

- 컴파일러에 의해 자동 관리, 개발자는 사용하기만 하면 됨

- this.멤버 형태로 멤버를 접근할 떄 사용

### this()로 다른 생성자 호출
- 같은 클래스의 다른 생성자 호출

- 생성자 내에서만 사용 가능

- 생성자 코드의 제일 앞에 있어야 함

- this() 사용 실패 사례
``` java
public Book() {
  System.out.println("생성자 호출됨");
        this("","",0); // 생성자의 첫 번쨰 문장이 아니기에 오류
    }
```

### 객체 배열
- 객체에 대한 레퍼런스 배열

- 자바의 객체 배열 만들기 3단계
  1. 배열 레퍼런스 변수 선언
  2. 레퍼런스 배열 생성
  3. 배열의 각 원소 객체 생성

### 메소드
- 메소드는 C/C++의 함수와 동일

- 자바의 모든 메소드는 반드시 클래스 안에 있어야 함

- 접근 지정자: 다른 클래스에서 메소드를 접근할 수 있는지 여부 선언
  - public, private, protected, 디폴트(접근 지정자 생략)

- 리턴 타입: 메소드가 리턴하는 값의 데이터 타입

### 인자 전달 - 기본 타입의 값이 전달되는 경우
- 매개 변수가 byte, int, double 등 기본 타입으로 선언되었을 때
  - ---> 호출자가 건네는 값이 매개 변수에 복사되어 전달. 실 인자 값은 변경되지 않음

### 인자 전달 - 객체가 전달되는 경우
  - 객체의 레퍼런스만 전달: 매개 변수가 실 인자 객체 공유

### 메소드 오버로딩
- 한 클래스 내에서 두 개 이상의 이름이 같은 메소드 작성
  - 메소드 이름이 동일해야 함
  - 매개 변수의 개수 혹은 타입이 달라야 함
  - 리턴 타입은 오버로딩과 관련 없음

### 오버로딩 실패 사례
- 매개 변수의 개수와 타입이 같기 때문에 오버로딩 실패

### 객체 치환 시 주의할 점
- 객체 지환은 객체 복사가 아니며, 레퍼런스의 복사이다.

### 객체 소멸
- new로 할당 받은 객체와 메모리를 JVM으로 되돌려 주는 행위

- 자바는 객체 소멸 연산자 없음

- 객체 소멸은 JVM의 고유한 역할


- C/C++에서는 할당 받은 객체를 개발자가 프로그램 내에서 삭제해야 함

- C/C++의 프로그램 작성을 어렵게 만드는 요인

- 자바에서는 사용하지 않는 객체나 배열을 돌려주는 코딩 책임으로부터 개발자 해방

### 가비지
- 가리키는 레퍼런스가 하나도 없는 객체

- 더 이상 접근할 수 없어 사용할 수 없게 된 메모리

- 가비지 컬렉션: 자바 가상 기계의 가비지 컬렉터가 자동으로 가비지 수정. 반환

### 가비지 컬렉션
- JVM이 가비지 자돋 회수
  - 가용 메모리 공간이 일정 이하로 부족해질 떄
  - 가비지를 수거하여 가용 메모리 공간으로 확보

- 가비지 컬렉터에 의해 자동 수행

- 강제 가비지 컬렉션 강제 수행: System 또는 Runtime 객체의gc() 메소드 호출
``` java
System.gc(); // 가비지 컬렉션 작동 요청

```

- 이 코드는 JVM에 강력한 가비지 컬렉션 요청

- 그러나 JVM이 가비지 컬렉션 시점을 전적으로 판단

### 자바의 패키지 개념
- 패키지

- 상호 관련 있는 클래스 파일(.class)을 저장하여 관리하는 디렉터리

- 자바 응용프로그램은 하나 이상의 패키지로 구성

### 접근 지정자
- 자바의 접근 지정자 4가지: private, protected, public, 디폴트

- 접근 지정자의 목적
  - 클래스나 일부 멤버를 공개하여 다른 클래스에서 접근하도록 허용
  - 객체 지향 언어의 캡슐화 정책은 멤버를 보호하는 것
  - -> 접근 지정은 캡슐화에 묶인 보호를 일부 해제할 목적으로 사용

- 접근 지정자에 따른 클래스나 멤버의 공개 범위

### 클래스 접근 지정
- 다른 클래스에서 사용하도록 허용할 지 지정

- public 클래스: 다른 모든 클래스에게 접근 허용

- 디폴트 클래스: 같은 패키지의 클래스에만 접근 허용

### 멤버 접근 지정
- public 멤버: 패키지에 관계 없이 모든 클래스에게 접근 허용

- private 멤버: 동일 클래스 내에만 접근 허용. 상속 받은 서브 클래스에서 접근 불가.

- protected 멤버:
  - 같은 패키지 내의 다른 모든 클래스에게 접근 허용
  - 상속 받은 서브 클래스는 다른 패키지에 있어도 접근 가능

- 디볼트 멤버: 같은 패키지 내의 다른 클래스에게 접근 허용

### static 멤버
- static 멤버 선언
``` java
class StaticSample() {
  int n;                  // non-static 필드
  void g() {...}          // non-static
  
  static int m;           // static 필드
  static void f() {...}   // static 메소드

}
```

- 객체 생성과 non-static 멤버의 생성
  - : non-static 멤버는 객체가 생성될 때, 객체마다 생긴다.

- 객체마다 n, g()의 non-static 멤버들이 생긴다.

### static 멤버 사용
- 클래스 이름으로 접근 가능
``` java
StaticSample.m = 3;
StaticSample.f();     
```

- 객체읭 멤버로 접근 가능

- non-static 멤버는 클래스 이름으로 접근 안됨

# ( 10월 2일 강의 )

### 자바 배열(array)
- 인덱스와 인덱스에 대응하는 데이터들로 이루어진 자료 구조로 한 번에 많은 메모리 공간 선언.

- 같은 타입의 데이터들이 순차적으로 저장되는 공간으로 인덱스를 이용하여 원소 데이터에 접근.

- 반복문을 이용하여 처리하기에 적합한 자료 구조

- 배열 인데스: 0부터 시작

### 배열 선언과 생성
- (1) 배열에 대한 레퍼런ㅁ스 변수 `intArray` 선언
  - int int Array [];

- (2) 배열 생성
  - intArray = new int [5];

### 배열 선언 및 생성 디테일
- 배열은 선언과 생성의 두 단계 필요 : 선언과 동시에 생성 가능.

- 배열 선언 : 배열의 이름 선언(배열 레퍼런스 변수 선언)
  - int intArray []; or int[] intArray;
  - int intArray [5]; // 크기 지정하면 오류가 발생

- 배열 생성 : 배열 공간 할당 받는 과정
  - intArray = new int[5]; or int intArray[] = new int[5]; // 선언과 동시에 저장

### 배열 인덱스와 배열 원소 접근
- 배열의 인덱스는 0부터, 크기는 1부터.

- 인덱스 잘못 사용
  - 음수 사용 불가
  - 인덱스 범위를 넘은 경우

- 반드시 배열 생성 후 접근

### 레퍼런스 치환과 배열 공유
- 레퍼런스 치환으로 두 레퍼런스가 하나의 배열 공유
  - int inArray[] = rew int[5];
  - int myArray[] intArray;

### 배열의 크기, length 필드
- 자바의 배열은 객체로 처리
- 배열의 크기는 배열 객체의 length 필드에 저장

### 함수호출 시 배열 전달 비교: C/C++ vs. 자바
- 자바가 C/C++에 비래 배열을 다루기 10배 편한 구조

### 배열과 for-each 문
- `for-each`문 : 배열이나 나열의 원소를 순차 접근하는데 우용한 `for`문

### 2차원 배열
- 2차원 배열 선언
  - int intArray[][]; or int[][]Array;
- 2차원 배열 생성
  - intArray = new int[2][5]; or int intArray[] = new int[2][5]; // 배열 선언과 생성 동시

- 2차원 배열의 length 필드
  - i.length --> 2차원 배열의 행의 개수로, 2
  - i[n].leng --> n번쨰 행의 열의 개수
  - i[1].length --> 1번째 행의 열의 개수, 5

### 2차원 배열의 초기화
  - 배열 선언과 동시에 초기화

### 메소드의 배열 리턴
- 배열의 레퍼런스만 리턴되며, 배열 전체가 리턴되는 것이 아님

- 메소드의 리턴 타입
  - 리턴하는 배열과 티런 받는 배열 타입이 일치
  - 리턴 타입에 배열의 크기르 지정하지 않음.

### 자바의 예외 처리
- 예외 : 실행 중 오동작이나 결과에 악영향을 미치는 예상치 못한 상황 발생 --> 자바에서는 실행 중 발생하는 에러를 예외로 처리

- 실행 중 예외가 발생하면 : 자바 츨랫폼은 응용프로그램이 예외를 처리하도록 호출 --> 응용프로그램이 예외를 처리하지 않으면 프로그램 강제 종료 시킴

### 자바의 예외 처리, try-catch-finally문
- 예외 처리 : 발생한 예외에 대해 개발자가 작성한 프로그램 코드에서 대응하는 것

- try-catch-finally문 사용. finally 블록은 생략 가능.

## 반복문
### `continue`문
- 반복문을 빠져 나가지 않고, 계속 다음 반복을 제어

### `break`문
- 반복문 하나를 즉시 벗어날 떄 사용. (하나의 반복문 만)
- 중첩 반복의 경우 안쪽 반복문의 break 문이 실행되면 안쪽 반복문만 벗어남.



# ( 9월 25일 강의 )
### 반복문
- 자바 반복문 - `for`, `while`, `do-while` 문
  - `for` : 반복의 휫수가 정해져 있을 때
  - `while` : 반복의 휫수가 무한일 떄
  - `do-while` : 조건식이 '참'인 동안 반복 실행. 작업문은 한 번 반드시 실행.

### 중첩 반복
- 반복문이 다른 반복문을 내포하는 구조
- 10000명의 학생이 있는 100개 대학의 모든 학생 설적의 합을 구할 떄, `for` 문을 이용하면 좋음

### Switch 문
- `Switch`문의 식과 `case` 문의 값과 비교
  - `case`의 비교 값과 일치하면 해당 `case`의 실행문장 수행
  - `break` 만나는 `switch`문을 벗어남
  - `case`의 비교 값과 일치하는 것이 없으면 `default` 문 실행
  - `default`문은 생략 가능

### While 문
- `While`문의 구성과 코드 사례 : 조건식이 '참'인 동안 반복 실행

``` java
public class Main {
    public static void main(String[] args) {
        switch(식){
          case'A':
          --- 실행 문장 1 ---
        }
    }
}
```

### case 문의 값
- 문자, 정수, 문자열 리터럴만 허용
- 실수 리터럴은 허용되지 않음

### do-while 문
- `do-while` 문의 구성과 코드 사례
  - 조건식이 '참'인 동안 반복 실행. 작업문은 한 번 반드시 실행.

### 다중 if-else 문

- 다중 if문

- 조건문이 너무 많은 경우, `switch` 문 사용 권장

``` java
public class Main {
    public static void main(String[] args) {
        if(조건식 1){
          --- 실행문장 1 ---
        }
        else if(조건식 2){
          --- 실행문장 2 ---
        }
        else if(조건식 m){
          --- 실행문장 m ---
        }
    }
}
```

### 조건문 - 단순 if문, if-else문
- 단순 if 문
  - if의 괄호 안에 조건식(논리형 변수나 논리 연산)
  
  - 실행문장이 단일 문장인 경우 둘어싸는 {, } 생략 가능

``` java
public class Main {
    public static void main(String[] args) {
        if(조건식){
          --- 실행문장 1 ---
        }
    }
}
```

- if-else 문
  - 조건식이 true면 실행문장 1, false면 실행문장 2 실행

``` java
public class Main {
    public static void main(String[] args) {
        if(조건식){
          --- 실행문장 1 ---
        }
        else{
          --- 실행문장 2 ---
        }
    }
}
```

### 비트 연산
- 비트 개념
  - 비트 논리 연산 : 비트끼리 AND, OR, XOR, NOT 연산
  
  - 비트 시프트 연산 : 비트를 오른쪽이나 왼쪽으로 이동

#### 비트 연산이 사용되는 경우
- 비트 연산은 하드웨어 프로그래밍 뿐만 아니라 일반 소프트웨어 개발에서도 여러 가지 용도로 사용.

- 성능이 중요한 경우, 최척화가 필요한 경우

1. 성능 최적화 및 연산 속도 향상 : `*` 과 `/` 보다 비트 연산 `<<`,`>>` 이 훨씬 빠름

2. 권한 및 플래그 설정 : 여러 개의 상태를 하나의 int 변수에 저장할 때 사용

3. 데이터 압축 및 최적화
  - 불필요한 공간 줄이기 위해 여러 개의 작은 값을 하나의 정수에 저장

4. 해상 및 암호화
  - 비트 연산을 활용하여 해시 함수 및 암호화 알고리즘 최적화

5. 빠른 연산

### 조건 연산
- 3개의 피연산자로 구성된 삼항(ternary) 연산자

- ope17opr2:opr3 --> opr1이 결과가, true면 opr2, false면 opr3

- if-else을 조건연산자로 간결하게 표현 가능

### 연산자
- 비교  
  - `>` : 크다 (Greater than) 
  - `<` : 작다 (Less than) 
  - `>=` : 크거나 같다 (Greater or Equal) 
  - `<=` : 작거나 같다 (Less or Equal) 
  - `==` : 같다 (Equal)  
  - `!=` : 같지 않다 (Not Equal) 

- 비트  
  - `&` : 비트 AND 
  - `|` : 비트 OR 
  - `^` : 비트 XOR  
  - `~` : 비트 NOT  

- 논리  
  - `&&` : 논리 AND (그리고)  
  - `||` : 논리 OR (또는)  
  - `!` : 논리 NOT (부정)  
  - `^` : 논리 XOR (배타적 OR)

# ( 9월 18일 강의 )
### 자바의 기본 구조
주석 / 클래스 생성 / main() 메소드 / 메소드 / 메소드 호출 / 변수 선언 / 문장 ; / 출력

### 식별자
- 정의 - 클래스, 변수, 상수, 메소드 등에 붙이는 이름

- 유니코드 사용 가능, 한글 사용 가능 --> 한글 추천 안함

- 자바 언어의 키워드는 식별자로 사용불가.

- 식별자의 첫 번째 문자로 숫자는 사용 불가.

- '_' 또는 '\'를 식별자 첫 번째 문자로 사용할 수 있으나 일반적으로 잘 사용하지 않는다.

- 불린 리터럴 (true, false)과 널 리터럴(null)은 식별자로 사용불가.

- 길이 제한 없음

- 대소문자 구별 : barChart 와 barchart 다른 식별자

### 데이터 타입

- 문자열은 기본 타입 아님. String 클래스로 문자열 표현

- 문자열 리터럴(Literal) : "JDK", "한글", "계속하세요"

- 문자열이나 문자열과 다른 자료형의 리터럴을 + 연산을 할 경우 결과는 문자열로 반환합니다.

### 참조 자료형

- 포인터는 임의의 메모리 주소로 저장, 참조 자료형은 주소 저장할 수 없음

- 직접 주소를 갖고 있지는 않지만, JVM이 해당 주소로 안내해줍니다.

- 참조 자료형은 JVM이 대신 객체의 주소를 저장.

- 배열, 인터페이스, 혹은, 열거형도 참조 자료형.

- 객체를 참조하지 않을 떄 null 값을 가짐.

- 같은 객체를 여러 변수가 참조, == 연산자로 객체의 주소를 비교 가능.

- '래퍼런스'라고 부르면 됨

### 메모리의 구조

- 힙( heap - FIFO ) 영역은 프로그래머가 직접 할당, 해제하는 메모리 공간, JVM이 담당
- 스택 ( stack - LIFO ) 영역은 프로그램이 자동으로 사용하는 임시 메모리
- 힙이 스택을 침범하는 경우 오버 플로우
    - 스택이 힙을 침범하는 경우 스택 오버 플로우 

### 상수 선언
- final 키워드 사용
- 선언할 때 초기값 지정
- 실행 중 값 변경 불가능

### var 키워드
- type 생략하고 변수 선언 가능
- 지역 변수 선언에만 사용 가능, class 필드에서는 사용 불가능
    - 지역 변수 : method 내부에 선언되는 변수
    - class 필드 : class 내부에 선언되는 변수, 객체가 생성될 떄 함께 만들어지는 변수.

### print
- `System.out.print();`
    - 줄 바꿈을 하지 않고 한 줄로 출력
- `System.out.println();`
    - 출력 후 자동으로 줄 바꿈
- `System.out.printf();`
    - 특정한 형식 ( 소수점 자리 수, 정렬 등 )으로 출력할 때 유용

### 타입 변환
- 다른 데이터 타입의 값으로 변환

### 연산자
- 증감  
  - `++` : 변수 값을 1 증가  
  - `--` : 변수 값을 1 감소  

- 산술  
  - `+` : 더하기  
  - `-` : 빼기  
  - `*` : 곱하기  
  - `/` : 나누기  
  - `%` : 나머지  

- 시프트  
  - `>>` : 오른쪽 시프트 (부호 유지)  
  - `<<` : 왼쪽 시프트  
  - `>>>` : 오른쪽 시프트 (부호 무시, 0으로 채움)  

- 비교  
  - `>` : 크다  
  - `<` : 작다  
  - `>=` : 크거나 같다  
  - `<=` : 작거나 같다  
  - `==` : 같다 (값 비교)  
  - `!=` : 같지 않다  

- 비트  
  - `&` : 비트 AND  
  - `|` : 비트 OR  
  - `^` : 비트 XOR  
  - `~` : 비트 NOT  

- 논리  
  - `&&` : 논리 AND (그리고)  
  - `||` : 논리 OR (또는)  
  - `!` : 논리 NOT (부정)  
  - `^` : 논리 XOR (배타적 OR)  

- 조건  
  - `? :` : 조건 연산자 (삼항 연산자)  

- 대입  
  - `=` : 대입  
  - `*=` : 곱 후 대입  
  - `/=` : 나눈 후 대입  
  - `+=` : 더한 후 대입  
  - `-=` : 뺀 후 대입  
  - `&=` : 비트 AND 후 대입  
  - `^=` : 비트 XOR 후 대입  
  - `|=` : 비트 OR 후 대입  
  - `<<=` : 왼쪽 시프트 후 대입  
  - `>>=` : 오른쪽 시프트 후 대입  
  - `>>>=` : 부호 무시 오른쪽 시프트 후 대입
   
# ( 9월 11일 강의 )

# ( 9월 4일 강의 )
# Markdown 문법

## HTML에서 `<h1>` ~ `<h6>`

# 글자 크기 
## 글자 크기
### 글자 크기
#### 글자 크기
##### 글자 크기
###### 글자 크기

# 문자 강조
*이탤릭체*  
**굵은 문자**

수평선
***

# 리스트 
* 언오더드 리스트
* 언오더드 리스트
* 언오더드 리스트
    * 언오더드 리스트
    * 언오더드 리스트
    * 언오더드 리스트
        * 언오더드 리스트
        * 언오더드 리스트
        * 언오더드 리스트

1. 오더드리스트
1. 오더드리스트
1. 오더드리스트


``` java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```
인라인 코드는 `버튼`이나 코드 조각을 강조할 때 사용

Vs Code에서 터미널을 열려면 `Ctrl` + `~`


# 링크

## 외부 링크
[구글 접속](https://google.com "구글 주소")

## 내부 링크
[링크 라벨](#markdwon-문법 "markdwon-문법")

# 그림 삽입
