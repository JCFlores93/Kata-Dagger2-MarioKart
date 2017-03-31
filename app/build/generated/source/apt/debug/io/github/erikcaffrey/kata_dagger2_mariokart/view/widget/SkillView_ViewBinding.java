// Generated code from Butter Knife. Do not modify!
package io.github.erikcaffrey.kata_dagger2_mariokart.view.widget;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import io.github.erikcaffrey.kata_dagger2_mariokart.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SkillView_ViewBinding<T extends SkillView> implements Unbinder {
  protected T target;

  @UiThread
  public SkillView_ViewBinding(T target, View source) {
    this.target = target;

    target.skillLabel = Utils.findRequiredViewAsType(source, R.id.label_skill, "field 'skillLabel'", TextView.class);
    target.skillProgress = Utils.findRequiredViewAsType(source, R.id.progress_skill, "field 'skillProgress'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.skillLabel = null;
    target.skillProgress = null;

    this.target = null;
  }
}