package ru.kpfu.itis.base.commands;

import ru.kpfu.itis.base.App;

public class GetNameCommand extends AbstractCommand{

  @Override
  public Object execute() {
    this.app.setName("Alexander");//Some logic instead of this
    return null;
  }
  
}
