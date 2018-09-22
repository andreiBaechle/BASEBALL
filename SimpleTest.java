package hw2;
import static hw2.CS227Baseball.*;


/**
*@Author Andrei Baechle
*/

public class SimpleTest
{
public static void main(String[] args)
{
CS227Baseball game = new CS227Baseball(3);
System.out.println(game);
game.pitch(CS227Baseball.STRIKE);
System.out.println(game); // should be 1 strike
game.pitch(CS227Baseball.BALL);
System.out.println(game); // 1 ball, 1 strike
game.pitch(CS227Baseball.STRIKE);
System.out.println(game); // 1 ball, 2 strikes
game.pitch(CS227Baseball.STRIKE);
System.out.println(game); // 0 balls, 0 strikes, 1 out
game.pitch(CS227Baseball.POP_FLY);
System.out.println(game); // 0 balls, 0 strikes, 2 outs
game.pitch(CS227Baseball.POP_FLY);
System.out.println(game); // 0 balls, 0 strikes, 0 outs, bottom inning
game.pitch(CS227Baseball.BALL);
System.out.println(game); // 1 ball, 0 strike
game.pitch(CS227Baseball.BALL);
System.out.println(game); // 1 ball, 0 strike
game.pitch(CS227Baseball.BALL);
System.out.println(game); // 1 ball, 0 strike
game.pitch(CS227Baseball.BALL);
System.out.println(game); // 1 ball, 0 strike
game.pitchWithHit(4);
System.out.println(game); // 0 ball, 0 strike
game.pitch(CS227Baseball.STRIKE);
System.out.println(game); // 0 ball, 1 strikes
game.pitch(CS227Baseball.STRIKE);
System.out.println(game); // 0 ball, 2 strikes
game.pitch(CS227Baseball.STRIKE);
System.out.println(game); // 0 ball, 3 strikes
game.pitch(CS227Baseball.STRIKE);
System.out.println(game); // 0 ball, 1 strikes
 }


}
