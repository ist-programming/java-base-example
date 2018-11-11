package ru.kpfu.itis.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import ru.kpfu.itis.base.commands.Command;
import ru.kpfu.itis.base.commands.ExitCommand;
import ru.kpfu.itis.base.commands.GetNameCommand;
import ru.kpfu.itis.base.commands.HelloCommand;

public class App {

  public static void main(String[] args) {
    try{
      InputStream in = new FileInputStream("/tmp/commands.txt");
//      InputStream in = System.in;
      new App(in, 
              new Command[]{new ExitCommand(), new HelloCommand(), new GetNameCommand()},
              new String[]{"exit", "hello", "greetings"}
      );
    }
    catch(IOException ex){
      System.out.println("Can't read command file");
      System.exit(1);
    }
  }
  
  //Weak coupling
  
  protected Scanner sc;
  protected Command[] commands;
  protected String[] commandNames;
  
  public App(InputStream in, Command[] commands, String[] commandNames){
    sc = new Scanner(in);
    this.commands = commands;
    this.commandNames = commandNames;
    for(Command command : this.commands){
      command.init(this);
    }
    start();
  }
  
  public void setName(String name){
    //Some simple logic
  }
  
  protected void start(){
    String enteredCommand;
    while(sc.hasNext()){
      enteredCommand = sc.nextLine();
      boolean foundCommand = false;
      for (int i = 0 ; i < commandNames.length ; i++) {
        if(commandNames[i].equals(enteredCommand)){
          foundCommand = true;
          commands[i].execute();
          break;
        }
      }
      if(!foundCommand){
        System.out.println("Unkown command");
      }
    }
  }
  
}
