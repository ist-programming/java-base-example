package ru.kpfu.itis.base.commands;

import ru.kpfu.itis.base.App;

public class ExitCommand implements Command{
  public Object execute(){
    System.exit(0);
    return null;
  }

  @Override
  public void init(App app) {}
}
