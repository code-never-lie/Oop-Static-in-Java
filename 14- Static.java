
         Static
- related to life time

  1- Static variables

Static in OOP
  2- static data members
  3- Static methods

Static variables
- life of static variables is equal whole program life   time
- created Once in memory 
- allocated when program Declaration Statement elaborated
- deallocated when program terminates
.......................................................
class Test {
public static void main(String o[]) {
int i=1;
while (i<=3){
   int j=1;// allocated in memory at each iterative step
   j++;
   System.out.println(j);
   i++;
}// j expires
}
}
- J alloactes and deallocatd three times
 OUTput 
2
2
2
...................................................
same program with static J
class Test {
public static void main(String o[]) {
int i=1;
while (i<=3){
static int j=1;//allocated once when program loaded 
   j++;
   System.out.println(j);
   i++;
}
}
- J alloactes once and terminated when program terminates
 OUTput 
2
3
4
........................................................
Static with Class type Varaible
.......................................................
class Cup{
public Cup() { System.out.println(" Cup created \n");}
}
class Test {
public static void main(String o[]) {
System.out.println(" start of main \n");
int i=1;
while (i<=3){
 Cup c=new Cup();//allocated and deallocated three times
    i++;
}
System.out.println(" end of main \n");
}
}
Output
Start of main 
cup created

cup created

cup created

end of main

..................................................
Same with Static
..............................................
class Cup{
public Cup() { System.out.println(" Cup created \n");}
}
class Test {
public static void main(String o[]) {
System.out.println(" start of main \n");
int i=1;
while (i<=3){
static Cup c=new Cup();//allocated once
    i++;
}
System.out.println(" end of main \n");
}
}
oUTput
Start of main 
cup created
end of main

.........................................................

Why we use Static variables?

Advantages
1- performance (it will save allocation/deallocation time)

2- history sensitive functions
   (save their state after return)
...............................................................
e.g Random() function
...................................................
e.g. History Sensitive Function
class History{
int  f() {//history Sensitive Function
static int i=1;// allocated once
i++;
 return i;
}
}

class Test {
public static void main(String o[]) {
History h= new History();
System.out.println(f());//2
System.out.println(f());//3
System.out.println(f());//4
}
}
OUTput 
2
3
4
............................................
Same without Static
 (c++ program covert to java)
................................................
int  f() {
int i=1;
i++;
 return i;
}
void main() {
cout<<f()<<endl;
cout<<f()<<endl;
cout<<f()<<endl;
}
OUTput 
2
2
2

.......................................................
Disadvantages

1- It will manopolize memory
2- Don't use until mandatory requirement (history sensitive,     performance)
..........................................................     
static data members
- within class static data members
- used when data sharing between objects is a requirement
- can be initialized within class
-  can be accessed with class reference using . operator    without object instanciation
 
....................................................
e.g. data sharing between objects
.................................................
Picnic Fund 
Student wants to contribute in picnic fund. Picnic Fund is a shared fund between students

class Student {
private int id;//exclusive
public static int pfund=0;//shared (allocated once)
public Student() { }
Student (int id ) {this->id=id;}
}
class Test {
public static void main(String o[]) {
Syetem.out.println(Student.pfund);//0
Student.pfund=10000;//univesity contributes 10000
Student goher=new Student(1);
Student fraz=new Student(2);
Student baig=new Student(3);
Student ayesha=new Student(4);
goher.pfund=goher.pfund+100;
fraz.pfund=fraz.pfund+500;
baig.pfund=baig.pfund+200;
ayesha.pfund=ayesha.pfund+0;
System.out.println("Goher wants to check Pfund ="+goher.pfund);
System.out.println("fraz wants to check Pfund ="+fraz.pfund);
baig.pfund=baig.pfund-200;// baig wants to revoke his money
System.out.println("ayesha wants to check Pfund ="+ayesha.pfund);
System.out.println("university wants to check Pfund ="+Student.pfund);
}
}
....................................................
e.g object Counting
....................................................
How many objects exist at present?

punjab Govt wants to track laptop objects that are being distributed to students


class LapTop{
public static int count=0;
public LapTop() { count++;}

}
class Test {
public static void main(String o[]) {
System.out.println(" Total LapTop delivered = +LapTop.count);
LapTop t1= new LapTop();
System.out.println(" Total LapTop delivered = +LapTop.count);
LapTop t2= new LapTop();
System.out.println(" Total LapTop delivered = +LapTop.count);
LapTop t3= new LapTop();
System.out.println(" Total LapTop delivered = +LapTop.count);
LapTop a[]= new LapTop[47];
System.out.println(" Total LapTop delivered = +LapTop.count);
}
}
Output
Total LapTop delivered =0
Total LapTop delivered =1
Total LapTop delivered =2
Total LapTop delivered =3
Total LapTop delivered =50
..............................................................
3- Static methods
- class member function can also be static
- can be called without object instanciation with class   reference
    Student.getPFUnd();
- static functions can use only static data members
..................................................................
Example PicnicFund Example  again with static functions
Picnic Fund example with private pfund variable

class Student {
private int id;//exclusive
private static int pfund=0;//shared (allocated once)
public Student() { }
public Student (int id ) {this->id=id;}
public static int getpfund() { return pfund;}
public static void  contribute(int amt) { pfund=pfund+amt;}
}

class Test {
public static void main(String o[]) {
System.out.println(Student.getpfund());
Student.contribute(10000);//univesity contributes 10000 
Student goher=new Student(1);
Student fraz=new Student(2);
Student baig=new Student(3);
Student ayesha=new Student(4);
goher.contribute(100);
fraz.contribute(100);
baig.contribute(100);
ayesha.contribute(0);
System.out.println("Goher wants to check Pfund ="+goher.getpfund());
System.out.println("fraz wants to check Pfund ="+fraz.getpfund());
baig.contribute(-200);
System.out.println("ayesha wants to check Pfund ="+ayesha.getpfund());
System.out.println("university wants to check Pfund ="+Student::getpfund());

}
..............................................................
Static Functions

e.g Meta classes
  - A class witout data members
 Stateless Objects
  - Object without Data

class Math {
public int sq (int p ) { return p*p;}
public int power (int x , int y){
         if (y==0)
             return 1;
         else
            return x * power(x,y-1);
}
}
class Test {
public static void main(String o[]) {
  Math m=new Math(); //state less object (object without data members)
  System.out.println(m.sq(2));
  System.out.println(m.power(2,3));
}
}
..........................................................
Rule of Thumb
- don't create state less objects
Remedy
- use static functions
................................................................
e.g Math Class Again ( Math meta class)

class Math {
public static int sq (int p ) { return p*p;}
public static int power (int x , int y){
      if (y==0)
         return 1;
      else
          return x * power(x,y-1);
}
}
class Test {
public static void main(String o[]) {
   System.out.println(Math.sq(2));
   System.out.println(Math.power(2,3));
}
}
..........................................................
Q- Develp Student Class with id as automatically generated number.

Student ob1 =new Student("Imran");// id 1


Student ob2= new Student("Khalid");// id 2

Student ob3= new Student("Shoaib");// id 3
.............................................................
#include <iostream>
#include <string>
using namespace std;

class Student {
private:
 static int counter;
 int id;
 string name;
public :
 Student () {counter++; id=counter; }
 Student (string n) {counter++; id=counter; name=n; }
 int getId() { return id;}
 string getName() { return name;}
 void setName(string n) {name=n;} 

};
int Student::counter=0;

void main() {
Student ob1("Shoaib");
Student ob2("Yasir");
Student ob3("Nabeel");
Student ob4;
ob4.setName("Adnan");
cout<<"id = "<<ob1.getId()<<endl;
cout<<"name = "<<ob1.getName()<<endl;
cout<<"id = "<<ob2.getId()<<endl;
cout<<"name = "<<ob2.getName()<<endl;
cout<<"id = "<<ob3.getId()<<endl;
cout<<"name = "<<ob3.getName()<<endl;
cout<<"id = "<<ob4.getId()<<endl;
cout<<"name = "<<ob4.getName()<<endl;
}
 
..................................................
Q- Develop Student Class with id as automatically generated number (use UCP ID Format).

Student ob1("Imran");// id L1f12bscs0001


Student ob2("Khalid");// id L1f12bscs0002

Student ob3("Shoaib");// id L1f12bscs0003
...........................................
#include <iostream>
#include <string>
using namespace std;

class Student {
private:
 static int counter;
 int  id;
 string name;
 
public :
 Student () {counter++; 
     
           id= counter; 
      }
 Student (string n) {
                   counter++; 
                   id= counter; 
                    name=n; 
 }
 int getId() { return id;}
 string getName() { return name;}
 void setName(string n) {name=n;} 

};
int Student::counter=0;
void main() {
Student ob1("Shoaib");
Student ob2("Yasir");
Student ob3("Nabeel");
Student ob4;
ob4.setName("Adnan");
cout<<"id = "<<"L1F12bscs000"<<ob1.getId()<<endl;
cout<<"name = "<<ob1.getName()<<endl;
cout<<"id = "<<"L1F12bscs000"<<ob2.getId()<<endl;
cout<<"name = "<<ob2.getName()<<endl;
cout<<"id = "<<"L1F12bscs000"<<ob3.getId()<<endl;
cout<<"name = "<<ob3.getName()<<endl;
cout<<"id = "<<"L1F12bscs000"<<ob4.getId()<<endl;
cout<<"name = "<<ob4.getName()<<endl;
}
.......................................................



Singleton Design Pattern

-Singleton means single object at a time


e.g  Biscuit 
kid can get one Biscuit at a time, second biscuit can't be taken until first is consumed


class Biscuit {
private  Biscuit ()  {}
private  static boolean flag=true;
public  static  Biscuit createBiscuit() { 
      if (flag==true){
          flag=false;   
          return new Biscuit();
       }else{
          System.out.println(" Already created ");
          return null;
 }
        
}
void eat() {
  System.out.println(" yummy tasty ........more .....");
}
static Biscuit consumeBiscuit() {
 System.out.println(" Biscuit Consumed");
           flag=true;
           return null;
}
}

class Test{
public static void main(String o[]) {
Biscuit b1;
b1=Biscuit.createBiscuit();
b1.eat();
Biscuit b2;
b2=Biscuit.createBiscuit();
if (b2!=null)
   b2.eat();
b1=Biscuit.consumeBiscuit();
b2=Biscuit.createBiscuit();
if (b2!=null)
   b2.eat();
}
}......................................................
     


    









