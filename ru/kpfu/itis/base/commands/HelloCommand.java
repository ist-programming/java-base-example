package ru.kpfu.itis.base.commands;

import ru.kpfu.itis.base.App;

public class HelloCommand implements Command{
  public Object execute(){
    System.out.println("Hello world");
    return null;
  }

  @Override
  public void init(App app) {}
}
