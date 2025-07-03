// TODO Put Year Copyright (c) {year} FRC 6423 - Ward Melville Iron Patriots
// https://github.com/FIRSTTeam6423
// 
// Open Source Software; you can modify and/or share it under the terms of
// MIT license file in the root directory of this project

package monologue;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class GlobalField {
  private static final AtomicBoolean initialized = new AtomicBoolean(false);
  private static final Field2d field = new Field2d();

  static void publish() {
    if (initialized.getAndSet(true)) {
      return;
    }
    Monologue.publishSendable("/Field", field, LogSink.NT);
  }

  public static synchronized void setObject(String name, Pose2d pose) {
    field.getObject(name).setPose(pose);
  }

  public static synchronized void setObject(String name, Pose2d... pose) {
    field.getObject(name).setPoses(pose);
  }

  public static synchronized void setObject(String name, List<Pose2d> pose) {
    field.getObject(name).setPoses(pose);
  }
}
