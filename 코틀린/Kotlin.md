#  Kotlin

## What is Kotlin

* Kotlin is a modern object oriented and functional programming language 
* Kotlin is a statically typed Programming language like Java
  * All the types are resolved at compile time

## Why Kotlin

* Kotlin is an expressive language and it has a concise syntax
  * Code readability and maintainability
* Kotlin is a safe language which prevents un-necessary errors
  * Prevents **NullPointerException** using the Nullable and Non-Nullable types

* Interoperable with Java
  * Kotlin and Java works together very well

## Kotlin build Process

* .kt(코틀린 파일) ->코틀린 컴파일러(JVM은 바이트 코드 읽으니까) -> .class 파일 -> .jar 해서 JRE가 jar 실행
  * 자바 빌드 프로세스랑 다른 건 .java를 자바 컴파일러가 .class 파일로 바꾸는 거 밖에 없음

## Kotlin variable

* val : 불변 변수, 한번 선언하면 변경 못함

```kotlin
val name : String = "Dillp"
```

* var: 변할 수 있는 변수

```kotlin
var name : Int = 33
```

## Kotlin Types

* there is no distinction between primitives and wrapper types
* All numbers in Kotlin are represented as types
  * Integer Types - Byte, Short, Int, Long
  * Floating-Point Types - Float, Double 
  * Character Type - Char
  * Boolean Type - Boolean

* 코틀린은 자동으로 타입 추론 한다, 그래서 타입 생략 가능.(Type Inference)

  ```kotlin
  val salay = 30000L
  ```

* String Interpolation and function

  ```kotlin
  val course = "Kotlin Spring"
      println("course : $course and length is ${course.length}")
  ```

* 개행표현

```kotlin
val multipleline = "ABC \nDEF"
println(multipleline)

//또는 
var multiline = """
        ABC
        DEF
    """.trimIndent()
println(multiline)
```

## Kotlin Condition

* 자바랑 비슷
* 근데 if - else 를 받을 수 있음. Kotlin.Unit은 No value를 의미.

```kotlin
fun main() {

    var name = "alex"
    val result = if (name.length == 4) {
        println("name is 4 character")
    } else {
        println("name is not 4 character")
    }

    println("result is $result") // "result is kotlin.Unit"
}
```

* if-else 구절 마지막 문장은 리턴을 의미

```kotlin
fun main() {

    var name = "alex"
    val result = if (name.length == 4) {
        println("name is 4 character")
        name.length
    } else {
        println("name is not 4 character")
    }

    println("result is $result") // "result is 4"
}
```

* when - 멀티 체크가 불필요한,  스위치- 케이스와 비슷

```kotlin
val medal2 = when (position) {
  1 -> {
    "gold"
  }
  2 -> {
    "silver"
  }
  else -> {
    "no"
  }
}

//간결히
val medal2 = when (position) {
  1 -> "gold"
  2 -> "silver"
  else -> "no"
}
```

## Kotlin Range And Loop

* range And Loop

```kotlin
val range = 2..10 // 2 <= x <= 10
for (i in range) {
  println("i = $i")
}

val reverseRange = 10 downTo 2
for (i in reverseRange) {
  println("i = $i")
}

for (i in reverseRange step 2) { //10 8 6 4 2 ,즉 2번째 값을 스킵
  println("i = $i")
}
```

* While - 자바랑 같음

```kotlin
var x = 1
while(x < 5){
 println("Value of x is $x") x++
}

var i = 0
do {
 println("Inside do while : $i") i++
}while (i < 5)
```

* break, continue, return-자바랑 같음

```kotlin
for (i in 1..5) {
  println("i in $i")
  //if(i == 3 )break
  if(i == 3 )return
}
```

* label - 명명(레퍼런싱)하는 느낌

```kotlin
loop@ for (i in 1..5) {
  println("i in $i")
  //if(i == 3 )break@loop
  innerloop@ for (j in 1..5) {
    //if(j==2) break@innerloop
    if(j==2) continue@loop
  }
}
```

## Kotlin Function

* 기본적인 구조

```kotlin
fun main() {
    printName("Bang")
}

fun printName(name: String) {
    println("Name is $name")
}
```

* 멀티 파라미터와 자동 타입 추론

```kotlin
fun main() {
    val result = addition(1, 2)
    println("result is $result")

    val result1 = addition_approach1(1, 2)
    println("result is $result1")
}

fun addition(x: Int, y: Int) : Int {
    return x+y
}

fun addition_approach1(x: Int, y: Int) = x+y
```

* 코틀린에서 반환 값이 없는 함수는 Unit 타입을 반환한다.(리턴타입에 Unit이 생략된거임)
* Unit은 타입이며, no value를 의미한다.

```kotlin
fun main() {
    val unitValue = printName("Bang")
    println("unitValue is $unitValue") //unitValue is kotlin.Unit
}

fun printName(name: String) : Unit{ //여기 Unit 없어도 위에처럼 받을 수 있음.
    println("Name is $name")
}
```

* Default Value Parameter: 디폴트 값 지정해 놓는 것. 
  * 디폴트 없으면 manadantory임.
  * 무슨 파라미터가 필요한지 몰라도 된다.

```kotlin
fun main() {
  printPersonDetails("bang")
}

fun printPersonDetails(
    name : String,
    email : String = " ",
    dob : LocalDate = LocalDate.now()
) {
   println("Name = $name, Email = $email, Dob = $dob") //Name = bang, Email =  , Dob = 2022-04-20
}

```

* Named Arguments: 아큐먼트에 네이밍을 할 수 있다.

  * 같은 아규면트 이름이 없는 함수를 부르려고 하면 컴파일 오류난다.

  * 아규먼트 이름만 맞으면 됨, 순서는 상관 없음
  * 같은 함수 이름, 파라미터 수가 다른 (오버로딩)있고 변수이름 한개 가지고만 함수 호출한다면? -> 파라미터 개수 적은게 불려지는 듯

  ```kotlin
  fun main() {
    printPersonDetails(name = "bang")
    printPersonDetails(dob = LocalDate.parse("2022-01-01"), email = "kbh@naver.com", name = "bang" ) // Name = bang, Email = kbh@naver.com, Dob = 2022-01-01 , 순서는 상관 없다.
  }
  
  fun printPersonDetails(
      name : String,
      email : String = " ",
      dob : LocalDate = LocalDate.now()
  ) {
     println("Name = $name, Email = $email, Dob = $dob")
  }
  
  fun printPersonDetails(
      name : String,
      dob : LocalDate = LocalDate.now()
  ) {
     println("Name = $name, Dob = $dob") //여기 호출 됨.
  }
  ```

  * 5분 40초 ~6분 8초 부분 이해 안감(Named Argument의 뷰티)

### Top Level Functions

* Functions that does not belong to a class are **top-level** functions
  * In Java , functions can only be part of class
  * In Java applications, you can find classes that just has some static methods which holds some common logic that can be used across the app(유틸리티 클래스 같은 것. 비즈니스 로직은 없는..)
* Kotlin avoids this by using top level functions that can be part of a **Kotlin file** not a class -> 즉 코틀린은 코틀린 파일에 펑션들을 넣어서 top-level 같은 개념을 피함.
* 예를 들어 다른 패키지 내에 코틀린 파일에 만든 함수를 다른 패키지 내에서 활용할 수 있음( 패키지 접근으로 임포트 해서 ) 
* 많은 Util, Helper 클래스를 작성한 경험이 있죠? Util 클래스 안에 static 키워드로 범용적인 메소드를 구현하곤 했습니다. Kotlin에서는 그냥 Top-level function으로 작성해주면 됩니다! (static 대신 Top level function)

### Top Level Properties

* In Kotlin, properties that does not belong to class are called top-level properties
  * In Java, you can only define properties in a class or an interface
  * Most common use case in a Java application is you may have to be define static constants in a class file that can be used across the app
* Kotlin avoids these by allowing us to create properties that can be part of a **Kotlin file** not a class
* 예를 들어 다른 패키지 내에 코틀린 파일에 만든 변수(상수)를 다른 패키지 내에서 활용할 수 있음( 패키지 접근으로 임포트 해서 ) 
  * const val courseName = "KotlinProgramming" 이면 courseName을 다른 곳에서도 쓸 수 있음(패키지 접근으로 임포트 해서) - 근데 이때 상수가 아니어도 되는데, 코틀린은 다른 곳에서도 쓸거면 상수로 할 것을 권장하고 있음.

## Kotlin Class

* new 를 할 필요 없이 인스턴스 생성 및 활용할 수 있음

```kotlin
class Person {
    fun action() {
        println("Walks")
    }
}

fun main() {
    val person = Person()
    person.action()
}
```

* Primary 생성자 - 프로퍼티를 게터 세터 없이 인스턴스 필드로 접근할 수 있다.
  * 생성자 파라미터에 디폴트 값을 줘서 인스턴스 생성시 파라미터 안주고 생성할 수도 있다.

```kotlin
class Person(
    val name : String, 
    val age: Int 
) {
    fun action() {
        println("Walks")
    }
}

fun main() {
    val person = Person("jhon", 25)
    println("Name is ${person.name} and Age is ${person.age}")
//    person.action()
}
```

* Secondary 생성자

```kotlin
class Item() {
    var name : String = "" //var 로 선언
    constructor(_name: String) : this() {
        name = _name
    }
}

fun main() {
    val item = Item("alex")
    println("item name is ${item.name}")
    item.name = "aaa" //var로 선언했기 때문에 변경 가능. 
    println("item name is ${item.name}") //aaa
}
```

* Primary 생성자와 Secondary 생성자 같이 있을 때

```kotlin
/*
class Person(
    val name : String ,
    val age: Int
) {
    var email : String = ""
    constructor(_email : String) : this() { //이건 당연히 안됨. 
        email = _email
    }
    fun action() {
        println("Walks")
    }
}*/

class Person(
    val name : String = "",
    val age: Int = 0
) {
    var email : String = ""
    constructor(_email : String) : this() {
        email = _email
    }
    fun action() {
        println("Walks")
    }
}

fun main() {
    val person = Person("jhon", 25)
    println("Name is ${person.name} and Age is ${person.age}")
    val person1 = Person(_email="abc@naver.com")
    println("Name is ${person1.name} and Age is ${person1.age} and email = ${person1.email}")
}
```

* 이것도 가능

```kotlin
class Person(
    val name : String = "",
    val age: Int = 0
) {
    var email : String = ""
    constructor(
        _email : String,
        _name : String = "",
        _age : Int = 0
        ) : this(_name, _age) {
        email = _email
    }
    fun action() {
        println("Walks")
    }
}

fun main() {
    val person2 = Person(_email="abc@naver.com", _age=2 , _name ="john")
    println("Name is ${person2.name} and Age is ${person2.age} and email = ${person2.email}")

}
```

* 근데 왠만하면 디폴트 파라미터를 가진 프라이머리 생성자를 활용해라.(오버로드)

### Init block

* 인스턴스 생성 할 때 초기화 로직을 두고 싶을때 사용

```kotlin
class Person(
    val name : String = "",
    val age: Int = 0
) {
    var email : String = ""
    var nameLength : Int = 0

    init {
        println("init!!")
        nameLength = name.length
    }
    constructor(
        _email : String,
        _name : String = "",
        _age : Int = 0
        ) : this(_name, _age) {
        email = _email
    }
    fun action() {
        println("Walks")
    }
}

fun main() {
    val person3 = Person(_email="abc@naver.com", _age=2 , _name ="john")
    println("Name is ${person3.name} and Age is ${person3.age} and email = ${person3.email} and email = ${person3.nameLength}")

//init!!
//Name is john and Age is 2 and email = abc@naver.com and email = 4
}
```

### data class

* Classes just holds the data can be categorized as data classes
  * DTOs, domain classes and value object classes fall under this category
  * In Java, these type of classes are also Java Beans
* 적어도 하나의 primary 생성자 파라미터를 가져야 한다

```kotlin
data class Course {
  // 이런거 안됨
}
```

* 장점1: data class는 클래스 인스턴스를 출력하면 프로퍼티 정보를 알려준다
  * 일반 클래스는 경로랑 주소값 보여줌..
    * ex) com.playground.classes.Item@2avwf3d
  * 쿼리로 얻은 데이터, API 데이터 전달 등에 사용하기 좋다.

```kotlin
data class Course(
    val id : Int,
    val name : String,
    val author : String
)

fun main() {
    val course = Course(1, "abc", "kbh")
    println(course) //Course(id=1, name=abc, author=kbh)

}
```

* 장점2: Automatically generates the equals(), hashCode() and toString() methods

```kotlin
data class Course(
    val id : Int,
    val name : String,
    val author : String
)

fun main() {
    val course = Course(1, "abc", "kbh")
    val course1 = Course(1, "abc", "kbh")
    println("equality check ${course == course1}") // true
}

```

* 장점3: 쉬운 카피(copy())

```kotlin
data class Course(
    val id : Int,
    val name : String,
    val author : String
)

fun main() {
    val course1 = Course(1, "abc", "kbh")
    val course2 = course1.copy( //완전히 다른 오브젝트
        id = 3,
        author = "kkk"
    )
    
    println(course2) // Course(id=3, name=abc, author=kkk)
}
```

### Getter and Setter

* 프로퍼티들에 대해 커스텀 로직이 필요할 때 사용.

#### getter

* 필드 아래에 선언되야 한다.(당연한..)
* 별 다른 로직 없이 아래와 같이 선언하면 접근할 수 있음.(get() = field)

```kotlin
class Item() {
    var name : String = ""
    var price : Double = 0.0
    get() = field

    constructor(_name: String) : this() {
        name = _name
    }
}

fun main() {
    val item = Item("alex")
    println(item.price)
}
```

* 또는 다른 신택스로 아래와 같이 할수도 있음. (로직 집어넣는 것도 가능)

```kotlin
class Item() {
    var name : String = ""
    var price : Double = 0.0
    get() {
        println("Inside Getter")
        return field
    }

    constructor(_name: String) : this() {
        name = _name
    }
}

fun main() {
    val item = Item("alex")
    println(item.price)
}
```

#### setter

* 필드 아래에 선언되야 한다.(당연한..)

```kotlin
class Item() {
    var name : String = ""
    var price : Double = 0.0
    get() {
        println("Inside Getter")
        return field
    }
    set(value) {
        println("Inside Setter")
        if (value >= 0.0) {
            field = value
        } else {
            throw java.lang.IllegalArgumentException("not allowed")
        }
    }

    constructor(_name: String) : this() {
        name = _name
    }
}

fun main() {
    val item = Item("alex")
    item.price = 10.0 //setter
    println(item.price) //getter
}
```

### Inheritance and Overriding

#### inheritance

* Any is the superclass for any class in Kotlin
  *  자바 **Object** 클래스랑 같은 느낌
*  All the classes in Kotlin are **final**
  *  Extending classes are not allowed by default (즉 그냥은 extend 못한다.)
* 그러나 open 모디파이어 사용해서 다른 클래스가 해당 클래스를 extend 가능하게 할 수 있다.
* 자바와 같이 여러 클래스를 extend 할 수는 없다.(1개 클래스만 가능)

```kotlin
open class User(val name: String) {

    fun login() {
        println("Inside user Login")
    }
}

class Student(name : String) : User(name)

class Instructor(name : String) : User(name)

fun main() {
    val student = Student("Alex")
    println("name is ${student.name}")
    student.login()

    val instructor = Instructor("Dillip")
    println("name is ${instructor.name}")
    instructor.login() 
}

```

#### Overriding

* 함수 오버라이딩

```kotlin
open class User(val name: String) {

    open fun login() {
        println("Inside user Login")
    }
}

class Student(name : String) : User(name) {

    override fun login() {
        println("Inside Student Login")
        super.login()
    }
}

fun main() {
    val student = Student("Alex")
    student.login()
}
//Inside Student Login
//Inside user Login

```

* 변수 오버라이딩

```kotlin
open class User(val name: String) {
    open var isLoggedIn : Boolean = false
}

class Student(name : String) : User(name) {
    override var isLoggedIn : Boolean = false
}


fun main() {
    val student = Student("Alex")
  
    student.isLoggedIn = true
    println("is loggin? ${student.isLoggedIn}") //true
}
```

### Object Keyword

* This keyword allows us to create a class and an instance of the class at the same time(cf. 싱글톤)

```kotlin
object Authenticate {
    fun authenticate(userName: String, password: String) {
        println("userName : $userName")
    }
}

fun main() {
    Authenticate.authenticate("Dilip", "abc")
}
```

### companion object

* 코틀린에선 static 키워드 없음. -> 코틀린에는 companion object 가 있음
* companin object 안에 변수를 넣을 수도 있는데 상수로 하길 권장함.

```kotlin
open class User(val name: String) {
}

class Student(name : String) : User(name) {
    companion object {
        const val noOfEnrolledCourse =10
        fun country() = "USA"
    }
}

fun main() {
    val student = Student("Alex")

    val country = Student.country()
    println("country is $country")
    println("noOfEnrolledCourse is ${Student.noOfEnrolledCourse}")
}

```

## Interface

* 여러 인터페이스를 구현할 수 있다.
* abstract 메소드가 있는 인터페이스

* abstract 메소드 없는(즉 구현이 있는 메소드를 가진 ) 인터페이스(자바의 디폴트)
  * 물론 오버라이드해서 다르게 구현할 수 있음

```kotlin
package com.kotlinplayground.`interface`

import com.kotlinplayground.classes.Course

interface CourseRepository {
    fun getById(id : Int) : Course

    fun save(course: Course) : Int {
        println("course : $course")
        return course.id
    }
}

class SqlCourseRepository : CourseRepository {
    override fun getById(id: Int): Course {
        return Course(id, "abc", "kbh")
    }
}

class NoSqlCourseRepository : CourseRepository {
    override fun getById(id: Int): Course {
        return Course(id, "abc", "kbh")
    }

    override fun save(course: Course): Int {
        println("course in NoSqlCourseRepository: $course")
        return course.id
    }
}

fun main() {
    val sqlCourseRepository = SqlCourseRepository()
    val course = sqlCourseRepository.getById(1)
    println("course is $course")
    val courseId = sqlCourseRepository.save(Course(5, "abc", "kbh")) 
    println("Saved course id is $courseId")

    val nosqlCourseRepository = NoSqlCourseRepository()
    val course2 = nosqlCourseRepository.getById(2)
    println("course2 is $course2")
    val courseId2 = nosqlCourseRepository.save(Course(6, "abc", "kbh"))
    println("Saved course id in nosqlCourseRepository is $courseId2")

}

//course is Course(id=1, name=abc, author=kbh)
//course : Course(id=5, name=abc, author=kbh)
//Saved course id is 5
//course2 is Course(id=2, name=abc, author=kbh)
//course in NoSqlCourseRepository: Course(id=6, name=abc, author=kbh)
//Saved course id in nosqlCourseRepository is 6
```

* 멀티플 인터페이스 구현할때 각 인터페이스에 같은 non-abstract method가 있는 경우
  * 제네릭 사용해서 해결하자

```kotlin
package com.kotlinplayground.`interface`

import com.kotlinplayground.classes.Course

interface A {
    fun doSomething() {
        println("doSomething in A")
    }
}

interface B {
    fun doSomething() {
        println("doSomething in B")
    }
}

class AB : A,B {
    override fun doSomething() {
      super<A>.doSomething()
        super<B>.doSomething()
        println("doSomething in AB")
    }
}


fun main() {
    val ab = AB()
    ab.doSomething()
}
//doSomething in A
//doSomething in B
//doSomething in AB
```

* 인터페이스 변수를 오버라이딩 하는 방법

```kotlin
package com.kotlinplayground.`interface`

import com.kotlinplayground.classes.Course

interface CourseRepository {
    var isCoursePersisted : Boolean
    fun getById(id : Int) : Course

    fun save(course: Course) : Int {
        println("course : $course")
        return course.id
    }
}

class NoSqlCourseRepository : CourseRepository {
    override var isCoursePersisted: Boolean = false

    override fun getById(id: Int): Course {
        return Course(id, "abc", "kbh")
    }

    override fun save(course: Course): Int {
        isCoursePersisted = true
        println("course in NoSqlCourseRepository: $course")
        return course.id
    }
}

fun main() {
    val nosqlCourseRepository = NoSqlCourseRepository()
    val course2 = nosqlCourseRepository.getById(2)
    println("course2 is $course2")
    val courseId2 = nosqlCourseRepository.save(Course(6, "abc", "kbh"))
    println("Saved course id in nosqlCourseRepository is $courseId2")
    println("nosqlCourseRepository.isCoursePersisted? ${nosqlCourseRepository.isCoursePersisted}") //true
}
```

## Visibility Modifiers

1. public - default
2. private - 해당 클래스에서만 접근 가능
3. protected - 해당 클래스 및 서부 클래스 에서 접근 가능
4. internal -  Anything that’s marked with internal is private to the module that’s published using the Gradle or Maven

* 주로 모디파이어 + open +fun+ 함수명() 이런식으로 씀.

```kotlin
protected open fun logout() {
  println("Inside user Login")
}
```

## Type Cheking & Casting

* is : 그 밸류가 어떤 타입인지 체크 (자바의 instance of와 같음)

```kotlin
import com.kotlinplayground.classes.Course

fun checkType(inputType: Any) {

    when(inputType) {
        is Course -> {
            //val course = inputType as Course // 이거 중복임 스마트캐스팅이 일어나므로 불필요
            println(inputType)
        }

        is String -> {
            println(inputType.lowercase())
        }
    }
}

fun main() {
    val course = Course(1, "abc", "kbh")

    checkType(course)
    checkType("Bang")
}
```

* as: 어떤 타입으로 밸류를 캐스팅함

```kotlin
fun castNumber(input: Any) {

    when(input) {
        input as Double -> println("Value is Double")

    }

}

fun main() {
    val course = Course(1, "abc", "kbh")
    castNumber(1.0)
    //castNumber(1) // 이거 익셉션 터짐, java.lang.Integer cannot be cast to class java.lang.Double
  
    val number = 1
    val numberDouble = number.toDouble()
    println(numberDouble) // 1.0
    
}

```

* 만약 캐스팅이 실패하면 java.lang.ClassCastException 터짐

## enum

```kotlin
package com.kotlinplayground.classes

data class Course(
    val id : Int,
    val name : String,
    val author : String,
    val courseCategory: CourseCategory = CourseCategory.DEVELOPMENT //개발은 디폴트밸류
)

enum class CourseCategory {
    DEVELOPMENT,
    BUSINESS,
}

fun main() {
    val course = Course(1, "abc", "kbh")
    println(course) // 따로 지정 안해줬으니 디폴트로 나옴
  //Course(id=3, name=abc, author=kkk, courseCategory=DEVELOPMENT)

    val course3 = Course(3, "abc", "kbh", CourseCategory.BUSINESS)
    println(course3)
  //Course(id=3, name=abc, author=kbh, courseCategory=BUSINESS)
}
```

 ## Nulls

* 코틀린에는 Nullable, Non - Nullable 타입이 있다 - 변수나 프로퍼티에 assign 할 수 있다.
* Nullable Type - null value도 가질 수 있는 타입

```kotlin
val name : String? = null
//또는
val name : String? = "Dilip"
```

* Non-Nullable Type: 무조건 non-null 밸류 있어야 함

```kotlin
val name : String = "Dilip"
//또는
val name = "Dilip"
```

* 그래서 언제 각 타입을 쓰냐

```kotlin
package com.kotlinplayground.nulls

data class Movie(
    val id: Int?, //DB를 생각했을때 이부분이 AI여서 DB에서 넘어오는 값이라면 우린 모름
    val name : String
)
fun main() {
    val movie = Movie(null, "AAA")
    val savedMovie = saveMovie(movie)
    println(savedMovie)
}

//아래와 같이 DB에서 id=1로 generated 됐다고 하면
fun saveMovie(movie: Movie) :Movie {
    return movie.copy(id = 1)
}
```

### 코틀린이 널을 아름답게 다루는 법

* safe call(?)  - safe하면 실행해라
* Elvis operator(?:) - 널이면 디폴트 밸류를 리턴해라. 

```kotlin
var name : String? = null 
if (name != null) { //일반적인 언어라면 아래의 length 때 NPE 피하기 위해 이렇게 할거임
  println(name.length)
}
//근데 코틀린은 ? safe operator를 활용해 null이 아니면 뒤의 메소드가 호출되게 함
println(name?.length) // 그래서 NPE 안터지고 그냥 이건 null이 나옴.

val length = name?.length ?: 0 //이렇게 디폴트 밸류 줄수도 있음, ?: 를 elvis operator라 함.
println(length) // 디폴트 안줫으면 여기서도 null 찍힘. 

val lengthString = name?.length?.toString() ?: 0 //그냥 Null일 수 있는 거면 ?. 하면 될듯.
```

* Non Null assertion(!!) - 널이 아님을 assertion(validation 느낌 )

```kotlin
package com.kotlinplayground.nulls


data class Movie(
    val id: Int?, //DB를 생각했을때 이부분이 AI여서 DB에서 넘어오는 값이라면 우린 모름
    val name : String
)
fun main() {
  
    val movie = Movie(null, "AAA")
    val savedMovie = saveMovie(movie)
    println(savedMovie.id!!) //여기서 NPE 터짐, 만약에 아래에서 1을 제대로 줫으면 1로 출력함.
    println(savedMovie)


}

fun saveMovie(movie: Movie) :Movie {
    //return movie.copy(id = 1)
    return movie
}

```

* 이것들은 캐스팅에서도 쓰임.  

```kotlin
package com.kotlinplayground.cast

import com.kotlinplayground.classes.Course

fun castNumber(input: Any) {

    when(input) {
        input as? Double -> println("Value is Double") //safe 하면 출력해라
    }
}

fun main() {
//    castNumber(1.0)
    castNumber(1)//이거 원래 ClassCastException 터지는데 위에서 ?(safe call) 했으므로 Exception은 안터짐, 물론 Value is Double 이거 출력도 안됨
}
```

* Nullable 타입으로 Non-nullable 타입에 Invoke 하려고 할 때

```kotlin
fun printName(name: String) {
    println("name is $name")
}
fun main() {
    var name : String? = null
//     printName(name) 당연히 이러면 타입 미스매치여서 컴파일 에러 남.
  //이를 해결하기 위해 scope function 활용함. 뒤 강의에서 자세히
  name?.run {
        printName(this) //null일경우 호출 안함.
   }
}
```

* Non-Nullable 타입을 nullable 타입에 assign하려고 할 때

```kotlin
fun printName1(name: String?) {
    println("name is $name")
}

fun main() {
    var name2 = "Dilip"
    printName1(name2) //그냥 하면 됨. 이슈 없음.
}
```

## Collection

* 자바꺼 쓴다(코틀린이 자체적으로 가지고 있는 콜렉션은 없음, 확장된 기능은 있음) 

* 두 가지 타입임

  1. Mutable Collection - 변경가능

  ```kotlin
  val names = mutableListOf("a","b","c")
  mutableMapOf("aa" to 33, "bb" to 5)
  mutableSetOf("aa","bb","cc")
  ```

  2. Immutable Collection - 생성되면 변경 불가

  ```kotlin
  val names = listOf("a","b","c")
  mapOf("aa" to 33, "bb" to 5)
  setOf("aa","bb","cc")
  ```

### Lambda in Kotlin

* 람다의 장점

  1. 행동을 변수에 assign 수 있다. ex) val add = {x : Int -> x+x}

  ```kotlin
  val addLambda = {x:Int, y:Int ->
          println("x is $x and y is $y")
          x+y}//마지막 라인이 리턴되는 값.
  val addResult = addLambda(2,3)
  println(addResult)
  ```

  2. 람다를 다른 함수의 argument로서 전달할 수 있다.
     * 그리고 함수를 리턴할 수 있다.(이런 형태의 함수를 Higher Order Function이라 함)

  ```kotlin
  //3번째 파라미터는 Int 타입 결과를 가진 람다를 받음.
  fun calculate(x: Int, y: Int, op: (x: Int, y: Int) -> Int): Int {
      return op(x, y)
  }
  
  fun main() {
      //람다가 마지막에 있으면 괄호 밖으로 뺄 수 있음
      //val result = calculate(2, 3, {a,b -> a*b})
      val result = calculate(2, 3) { a, b -> a * b }
      println(result)
      
      val result2 = calculate(2, 3) { a, b -> a + b }
      println(result2)
  }
  ```


#### Filter Operator

* it operator: list에서 각 element에 접근하게 해주는 것,

```kotlin
fun main() {
    val courseList = courseList() //이건 dataset 파일에 정의된 함수. 강의 다 받아오는 것
    exploreFilter(courseList)
}

fun exploreFilter(courseList: MutableList<Course>) {
   courseList
        .filter { it.category == CourseCategory.DEVELOPEMENT }
        .forEach{
            println(it)
        }
}

//람다 이용
//함수를 파라미터로 줘서 원하는 거 쉽게 갈아끼게끔? 할 수 있음
fun main() {
    val courseList = courseList()

    val devPredicate = {c:Course -> c.category == CourseCategory.DEVELOPEMENT}
    val designPredicate = {c:Course -> c.category == CourseCategory.DESIGN}
    exploreFilter(courseList, devPredicate)
    //exploreFilter(courseList, designPredicate)
}

//여기서 predicate라는 명명은 변경할 수 있음.
fun exploreFilter(courseList: MutableList<Course>,
                  predicate : (Course) -> Boolean) {

    courseList
        .filter { predicate.invoke(it) }
        .forEach{
            println(it)
        }
}
```

#### Map Operator

* 기존 폼을 다른 폼으로 변경할때 주로 사용

```kotlin
fun main() {
    val courseList = courseList()
    exploreMap(courseList)
}

fun exploreMap(courseList: MutableList<Course>) {
    courseList
        .map{"${it.name} - ${it.category}"}
        .forEach{
            println(it)
        }
}
```

* 필터와 혼합

```kotlin
fun main() {
    val courseList = courseList()

    val devPredicate = {c:Course -> c.category == CourseCategory.DEVELOPEMENT}
    val designPredicate = {c:Course -> c.category == CourseCategory.DESIGN}
    exploreMap(courseList, designPredicate)
}

fun exploreMap(
    courseList: MutableList<Course>, designPredicate: (Course) -> Boolean,
                ) {
    courseList
        .filter(designPredicate) //위에꺼랑 좀 다른데.. 설명하는데 모르겟음..
        .map{"${it.name} - ${it.category}"}
        .forEach{
            println(it)
        }
}

```

#### flatMap

* 컬렉션 속의 컬렉션을 가지고 뭔가 할때 사용. 

```kotlin
val mapResult = list.map { outerList ->
            outerList.map{
                it.toDouble() //혼동 피하기 위해서 밖에는 내가 람다변수명 설정하고 안에서는 it operator 씀.
            }
        }
        println(mapResult) //[[1.0, 2.0, 3.0], [1.0, 2.0, 3.0]]

            val flatMapResult = list.flatMap { outerList ->
                outerList.map{
                    it.toDouble() 
                }
            }
        println(flatMapResult)//[1.0, 2.0, 3.0, 1.0, 2.0, 3.0]
```

```kotlin
package com.kotlinplayground.collections

import com.kotlinplayground.dataset.Course
import com.kotlinplayground.dataset.CourseCategory
import com.kotlinplayground.dataset.KAFKA
import com.kotlinplayground.dataset.courseList

fun main() {
    val courseList = courseList()
    val courses = exploreFlatMap(courseList, KAFKA)
    println(courses) 
  //[Apache Kafka for Developers using SpringBoot, Apache Kafka for Beginners]

}

fun exploreFlatMap(courseList: MutableList<Course>, kafka: String): List<String> {

    val kafkaCourse = courseList.flatMap { course ->
        val courseName = course.name
        course.topicsCovered.filter {
            it ==kafka
        }.map {
            courseName
        }
    }
    return kafkaCourse
}
```

#### hashMap

```kotlin
fun exploreHashMap() {
    val nameAgeMutableMap = mutableMapOf("A" to 33 , "bbbbbb" to 2)
    nameAgeMutableMap.forEach{(k,v) ->
        println("key is $k and value is $v")
    }

//    val value = nameAgeMutableMap.get("A")
    val value = nameAgeMutableMap["A"]
    println(value)

    //키 없으면 "abc"가 디폴트 밸류
    val value2 = nameAgeMutableMap.getOrElse("A1") { "abc" }
    println(value2) //abc

    val result = nameAgeMutableMap.containsKey("A1")
    println(result)

    val filterMap = nameAgeMutableMap.filterKeys {it.length > 5 }
        .map { it.key.uppercase() }
    println(filterMap)// [BBBBB]

    val maxAge = nameAgeMutableMap.maxByOrNull {it.value }
    println(maxAge) //A=33
}

```

### Sequence

* Collection의 대체 API?
* Lazy evaluation of Collections using Sequence
  * 즉, 스트림을 돈다고 하면 통으로 도는게 아니라 엘리먼트 하나씩 다돌고 다시 돌고의 느낌
* 종료 operator가 있어야 하는 듯.
* 장점: 다뤄야 하는 컬렉션이 매우 크면 일반적인 컬렉션보다 수행능력이 좋음
  * 각 operator에 대해 intermediate collection을 만들지 않는다
  * sequence는 lazy이기 때문에 컬렉션의 모든 요소에 operation을 하지 않는다.

```kotlin
fun main() {

    val nameListUsingSequence = listOf("alex", "ben", "chloe")
        .asSequence()
        .filter { it.length >=4 }
        .map {it.uppercase() }
        .toList()

    println(nameListUsingSequence)

    val range = 1 .. 1000_000_000

//이렇게 하면 다 더블로 바꾸고 나서 출력임 그리고 각 숫자들 다 리스트에 저장해야 해서 메모리 이슈 있음
//    range.map { it.toDouble() }
//        .forEach{println(it)}

    //이건 쭉 출력 됨, 중간에 intermediate collection을 만들지 않아서 메모리 이슈도 없음
//    range
//        .asSequence()
//        .map { it.toDouble() }
//        .forEach{println(it)}

    //40개까지 출력
    range
        .asSequence()//여기서 만약 이거 지우면 또 위와같이 출력안되고 oom, 저거 다 바꾸고 저장하는게 먼저라서..
        .map { it.toDouble() }
        .take(40)
        .forEach{println(it)}
}
```

### Nullability 

* 컬렉션이 널을 다루는 방법

```kotlin
fun collections_nullability() {
   
  //컬렉션 자체가 널일경우
//    val list : List<String>?=null
//    //list가 null일 수 있으면 이렇게 safeOperator 로 써야한다.
//    list?.forEach{블라블라}

    var list : MutableList<String>?=null
    list= mutableListOf() //이렇게 초기화 해서 safe operator안쓰고 할 수도 있다.
    list.add("kbh")
    list.forEach{println(it)}

    //컬렉션의 밸류가 널일 수 있음
    val list1 : List<String?> = listOf("Adam",null,"Alex")
    list1.forEach{
        println(it?.length) //value가 null일 수 있으므로 safe operator 필요
    } 
     //4
     //null
     //4
}

```

## Exception

* 코틀린에서 모든 익셉션은 throwable class를 extend한다

* try - catch 블럭 이용(코틀린에서 try-catch는 expression 이다.)

* checked exception은 없음

  * 예를들어 자바에서 FileInputStream으로 파일 읽을 때 익셉션 안던지면 컴파일 에러 나는데 코틀린은 그런거 없음

  ```kotlin
  package com.kotlinplayground.exceptions
  
  //Nothing 타입은 리턴하는게 없는 것.
  fun returnNothing() : Nothing {
      throw java.lang.RuntimeException("Exception")
  }
  
  fun main() {
  
      println(nameLength("Aaa")) //3
      println(nameLength(null)) //null
      returnNothing()
  }
  
  fun nameLength(name: String?): Int? {
      //return name!!.length //null 올경우 !!로 assertion 했으므로 NPE 터짐
  
  //    try {
  //        return name!!.length
  //    }catch (ex: Exception) {
  //        println(ex)
  //        return null
  //    }
      //이렇게 쓸 수도 있음
  //    return try {
  //        name!!.length //마지막 라인은 리턴 라인이다.
  //    }catch (ex: Exception) {
  //        println(ex)
  //        null
  //    }
  
      var result =try {
          name!!.length
      }catch (ex: Exception) {
          println(ex) //java.lang.NullPointerException
          null
      }
  
      return result
  
  }
  
  ```

## Scope Function

* 오브젝트의 컨텍스트 내의 a piece of code를 실행시키는 함수
* 람다랑 같이 쓰면 일시적인 scope가 생긴다네
* let, run, with, apply , also 있음

```kotlin
// scope function
var nameNullable : String? = null
nameNullable?.run{
  printName(this)
}

// 일반적인 경우, 널체킹 하고 출력
if(nameNullable!=null){
  printName(nameNullable)
}
```

### apply, also

* apply
  * Object Configuration 할 때 사용
  * return Context Object
  * Object reference : this
* also
  * Additional effects 할 때 사용
  * return Context Object
  * Object reference : it

```kotlin
package com.kotlinplayground.scopefunctions

import com.kotlinplayground.classes.Course
import com.kotlinplayground.classes.CourseCategory

fun main() {
    exploreApply()
    exploreAlso()
}

fun exploreAlso() {

    val course = Course(1, "abc", "kbh")
        .apply {
            courseCategory = CourseCategory.DESIGN
//            this.courseCategory = CourseCategory.DESIGN
        }
        .also {
//            it.courseCategory = CourseCategory.DESIGN
            println(it) //Additional effect
        }
 //also에서 하면 되므로 여기서 print할 필요 없음
}

fun exploreApply() {
    //원래 course의 디폴트 카테고리는 development인데 아래와 같이 변경필요할때 apply 활용
    val course = Course(1, "abc", "kbh")
        .apply {
            courseCategory = CourseCategory.DESIGN
//            this.courseCategory = CourseCategory.DESIGN
        }
    println(course)
}
```

### let

* let
  * 함수를 더 invoke할때 사용
  * return 람다
  * Object reference : it

```kotlin
package com.kotlinplayground.scopefunctions

fun main() {
    exploreLet()
}

fun exploreLet() {
   val numbers = mutableListOf(1,2,3,4,5)
    //let 안쓰면
//    val result = numbers.map { it * 2 }.filter { it > 5 }
//    println(result)

    //let 쓰면
    val result = numbers.map { it * 2 }.filter { it > 5 }.let {
        println(it) //이런식으로 안에다 그냥 출력하면 됨
        it.sum()//더 추가적인 함수 호출도 가능
    }
    println(result)

    //let은 non-nullable에 해야한다
    var name :String? = null
//    name.let {
//        println(it)
//        //it.uppercase()//컴파일 이슈 생김
//    }
    //그래서 safe하게 해야함
    val result1 = name?.let{
        println(it)
        it.uppercase()
    }
    println(result1)
}
```

### with, run

* with, run 둘다 다른 scope function과 달리 extension function으로 안해도 된다.(이전 것들은 다 object에 .  붙여서 사용했음)
* with
  * 오브젝트에 대해서 이것저것 할 때 사용
  * 오브젝트가 아규먼트로서 전달됨.
  * return 람다
  * Object reference : this
* run
  * 람다가 오브젝트 초기화도 있고 리턴 value 계산도 있을때 유용
  * with랑 비슷한데 let처럼 (extension 함수처럼) invoke할 수 있음. (ObjectReference : this)
  * 오브젝트 없이 그냥 단독으로 쓰일 수 있음 
  * return 람다

```kotlin
package com.kotlinplayground.scopefunctions

fun main() {
//    exploreApply()
//    exploreAlso()
//    exploreLet()
    exploreWith()
    exploreRun()
}

fun exploreRun() {

    var numbers : MutableList<Int>? =null
    val result = numbers.run {
        numbers = mutableListOf(1,2,3) //초기화
        numbers?.sum()//리턴 밸류 계산
    }
    println(result)

    val length = run { //파라미터 같이 받는 거 없음
        val name = "kbh"
        println(name)
        name.length
    }

    println(length)
}

fun exploreWith() {

    val numbers = mutableListOf(1,2,3,4,5)
    val result = with(numbers) { //아규먼트로 오브젝트 받음
//        println(numbers.size)
//        val list = numbers.plus(6)
//        list.sum()
        //레퍼런스 필요 없음
        println(size)
        val list = plus(6)
        list.sum()
    }
    println(result) //21

}

```

* scope 함수는 공식 docs보는게 더 좋을 듯.(https://kotlinlang.org/docs/scope-functions.html)