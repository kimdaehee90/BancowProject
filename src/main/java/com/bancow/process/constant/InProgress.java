package com.bancow.process.constant;

import java.util.List;
import java.util.ArrayList;

public enum InProgress {
    STEP1_IN_PROGRESS,              // 1차 작성중
    STEP1_COMPLETED,                // 1차 제출 완료
    STEP2_IN_PROGRESS,              // 2차 작성중
    STEP2_COMPLETED,                // 2차 제출 완료
    INVESTIGATION_REQUEST,          // 실사 요청일
    PROCESS_DONE;                   // 입점 완료



//    List<InProgress> Step1InProgressList = List.of(STEP1_IN_PROGRESS,STEP1_COMPLETED);

    public static List<InProgress> getStep1InProgressList() {
        List<InProgress> step1ProgressList = new ArrayList<>();
        step1ProgressList.add(STEP1_IN_PROGRESS);
        step1ProgressList.add(STEP1_COMPLETED);
        return step1ProgressList;
    }

    public static List<InProgress> getStep2InProgressList() {
        List<InProgress> step2ProgressList = new ArrayList<>();
        step2ProgressList.add(STEP2_IN_PROGRESS);
        step2ProgressList.add(STEP2_COMPLETED);
        return step2ProgressList;
    }

    public static List<InProgress> getStep3InProgressList() {
        List<InProgress> step3ProgressList = new ArrayList<>();
        step3ProgressList.add(INVESTIGATION_REQUEST);
        step3ProgressList.add(INVESTIGATION_CONFIRM);
        step3ProgressList.add(PROCESS_DONE);
        return step3ProgressList;
    }
}
