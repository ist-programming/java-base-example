package ru.kpfu.itis.base.commands;

import ru.kpfu.itis.base.App;

public interface Command {
  public Object execute();
  public void init(App app);
}
