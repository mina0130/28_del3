import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;
import gui_fields.GUI_Field;
public class GameBoard {

 GUI_Field[] fields = new GUI_Field[16];

 public void settingcar(GUI_Player player){
 fields[0].setCar(player, true);}



}

