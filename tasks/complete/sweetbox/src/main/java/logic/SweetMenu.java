package logic;

import sweets.AnotherSweet;
import sweets.Sweetnees;
import sweets.candy.CandyChew;
import sweets.candy.CandyChocoBar;
import sweets.candy.CandyCoco;
import sweets.candy.CandyRom;
import sweets.chocolate.ChocolateCube;
import sweets.chocolate.ChocolateEgg;
import sweets.jelly.JellyCola;
import sweets.jelly.JellyRandom;
import sweets.lollypop.LollypopInStick;
import sweets.lollypop.LollypopXXL;



public class SweetMenu {

    private  Sweetnees [] sweetMenu;

    public SweetMenu() {
        sweetMenu = new Sweetnees[]{
                new AnotherSweet(),
                new CandyChew(),
                new CandyChocoBar(),
                new CandyCoco(),
                new CandyRom(),
                new ChocolateCube(),
                new ChocolateEgg(),
                new JellyCola(),
                new JellyRandom(),
                new LollypopInStick(),
                new LollypopXXL()
        };
    }

    public Sweetnees[] getSweetMenu() {
        return sweetMenu;
    }
}
