package com.bancow.process.domain;

public enum InProgress {
    STEP1_IN_PROGRESS,              // 1차 작성중
    STEP1_COMPLETED,                // 1차 제출 완료
    STEP2_IN_PROGRESS,              // 2차 작성중
    STEP2_COMPLETED,                // 2차 제출 완료
    INVESTIGATION_REQUEST,          // 실사 요청일
    INVESTIGATION_CONFIRM,          // 실사 확정일
    PROCESS_DONE                    // 입점 완료

}
