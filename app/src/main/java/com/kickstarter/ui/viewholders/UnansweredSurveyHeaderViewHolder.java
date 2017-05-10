package com.kickstarter.ui.viewholders;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.kickstarter.R;
import com.kickstarter.libs.KSString;
import com.kickstarter.libs.utils.ObjectUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UnansweredSurveyHeaderViewHolder extends KSViewHolder {

  private final KSString ksString;

  @Bind(R.id.heading) TextView headingTextView;

  public UnansweredSurveyHeaderViewHolder(final @NonNull View view) {
    super(view);
    ButterKnife.bind(this, view);

    ksString = environment().ksString();
  }
  @Override
  public void bindData(final @Nullable Object data) throws Exception {

    // Null data means we should hide the view
    if (data == null) {
      headingTextView.setVisibility(View.GONE);
      return;
    }

    final int unansweredSurveyCount = ObjectUtils.requireNonNull(
      (int) data
    );
    headingTextView.setText(
      ksString.format(
        "Reward_Surveys",
        unansweredSurveyCount,
        "reward_survey_count",
        String.valueOf(unansweredSurveyCount)));

    headingTextView.setVisibility(unansweredSurveyCount > 0 ? View.VISIBLE : View.GONE);
  }
}
