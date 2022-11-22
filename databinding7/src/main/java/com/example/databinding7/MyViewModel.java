package com.example.databinding7;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author AlexisYin
 */
public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> aTeamScore;
    private MutableLiveData<Integer> bTeamScore;

    private Integer aLast;
    private Integer bLast;

    public MutableLiveData<Integer> getATeamScore() {
        if (aTeamScore == null) {
            aTeamScore = new MutableLiveData<>();
            aTeamScore.setValue(0);
        }
        return aTeamScore;
    }

    public MutableLiveData<Integer> getBTeamScore() {
        if (bTeamScore == null) {
            bTeamScore = new MutableLiveData<>();
            bTeamScore.setValue(0);
        }
        return bTeamScore;
    }

    public void aTeamAdd(int i) {
        saveLastScore();
        aTeamScore.setValue(aTeamScore.getValue() + i);
    }

    public void bTeamAdd(int i) {
        saveLastScore();
        bTeamScore.setValue(bTeamScore.getValue() + i);
    }

    public void undo() {
        aTeamScore.setValue(aLast);
        bTeamScore.setValue(bLast);
    }

    private void saveLastScore(){
        aLast = aTeamScore.getValue();
        bLast = bTeamScore.getValue();
    }

    public void reset() {
        aTeamScore.setValue(0);
        bTeamScore.setValue(0);
    }
}
