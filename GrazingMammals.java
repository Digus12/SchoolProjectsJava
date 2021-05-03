import java.util.*;

interface RuminantTester{ //interface RuminantTester
//below are two functions that are only defined
void testIfRuminant();
void testHasMultipleStomachs();
}

abstract class Mammal{ //abstract class mammal

//below function is implemented
public void nursesYoung(){
String classname = this.getClass().getName();
System.out.println("I am a "+ classname + ". I am nuring");
}
}

abstract class GrazingMammal extends Mammal implements RuminantTester{ //abstract class GrazingMammal

public void testIfRuminant(){
String className = this.getClass().getName();
if(this instanceof Ruminant){
System.out.println("I am a "+ className + ". I am a Ruminant");
}
else {
System.out.println("I am a "+ className + ". I am not a Ruminant");
}
}

public void testHasMultipleStomachs(){
String className = this.getClass().getName();
if(this instanceof Ruminant){
System.out.println("I am a "+ className + ". I have multiple Stomachs");
}
else {
System.out.println("I am a "+ className + ". I do not have multiple stomachs .");
}
}
boolean grazes(){
return true;
}
}

class Ruminant extends GrazingMammal{ //class Ruminant extending GrazingMammal

public void nursesYoung(){
String classname = this.getClass().getName();
System.out.println("I am a "+ classname + ". I am nuring");
}
boolean chewCud(){
return true;
}
}

class Cow extends Ruminant{

}

class Goat extends Ruminant{

}

class Horse extends GrazingMammal{

}

class Testmammals{
public static void main(String[] args) {
Cow cow = new Cow();
cow.nursesYoung();
cow.grazes();
cow.chewCud();
cow.testIfRuminant();
cow.testHasMultipleStomachs();
System.out.println("\n");
Goat goat = new Goat();
goat.nursesYoung();
goat.grazes();
goat.chewCud();
goat.testIfRuminant();
goat.testHasMultipleStomachs();
System.out.println("\n");
Horse horse = new Horse();
horse.nursesYoung();
horse.grazes();
horse.testIfRuminant();
horse.testHasMultipleStomachs();
}
}