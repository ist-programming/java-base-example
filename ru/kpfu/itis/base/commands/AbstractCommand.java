package ru.kpfu.itis.base.commands;

import ru.kpfu.itis.base.App;

/**
 * Better to extend this instead of just implementation Command interface.
 */
public abstract class AbstractCommand implements Command{

  protected App app;
  
  @Override
  public void init(App app) {
    this.app = app;
  }
  
}
