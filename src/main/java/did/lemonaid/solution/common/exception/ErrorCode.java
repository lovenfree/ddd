package did.lemonaid.solution.common.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum  ErrorCode {
    // Common
    INVALID_INPUT_VALUE(400, "RAEL.C001", "Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, "RAEL.C002", "METHOD_NOT_ALLOWED"),
    ENTITY_NOT_FOUND(400, "RAEL.C003", "Entity Not Found"),
    INTERNAL_SERVER_ERROR(500, "RAEL.C004", "Server Error"),
    INVALID_TYPE_VALUE(400, "RAEL.C005", "Invalid Type Value"),
    HANDLE_ACCESS_DENIED(403, "RAEL.C006", "Access is Denied"),
    MISSING_REQUEST_HEADER(400, "RAEL.C007", "Missing required header"),


    SESSION_NOT_FOUND_EXCEPTION(400, "RAEL.C008", "등록된 세션 정보 없음"),
    ORG_NOT_FOUND_EXCEPTION(400, "RAEL.C009", "기관 정보 없음"),
    DID_FILE_NOT_FOUND(400, "RAEL.C010", "DID 파일이 존재하지 않습니다."),
    RDSA_EXCEPTION(400, "RAEL.C011", "RDSA 연계 오류"),
    SECRET_KEY_NOT_FOUND_EXCEPTION(400, "RAEL.C012", "암호화 키 없음"),
    PUBKEY_NOT_FOUND_EXCEPTION(400, "RAEL.C013", "구간 암호화 publickey 없음"),
    LINK_RESULT_NOT_FOUND_EXCEPTION(400, "RAEL.C014", "연계처리 결과 없음"),
    SYSTEM_NOT_READY_EXCEPTION(400, "RAEL.C015", "시스템 사용 불가 (기관정보 및 라이센스 등록 후 사용)"),
    RDSA_LICENSE_EXPIRED_EXCEPTION(400,"RAEL.C016","RDSA 라이센스 기간이 만료"),


    AUTH_FAIL(401, "RAEL.C017", "자격 증명에 실패"),
    INVALID_ACCOUNT_STATUS(401, "RAEL.C018", "비활성화 된 계정"),
    INVALID_ACCOUNT_DUPLICATED(401, "RAEL.C019", "중복된 아이디 존재"),
    INVALID_ACCOUNT_INFO(401, "RAEL.C024", "계정 ID/PW 불일치"),
    ACCOUNT_NOT_FOUND(400, "RAEL.C020", "계정 정보 없음"),
    INVALID_DID_INFO(400, "RAEL.C021", "DID 정보 불일치"),
    IDP_EXCEPTION(400, "RAEL.C022", "IDP 연계 오류"),
    OFFICEPLUS_EXCEPTION(400, "RAEL.C023", "OfficePlus 연계 오류"),

    JWT_EXPIRED_EXCEPTION(401, "RAEL.C030", "토큰 유효기간 만료"),
    JWT_INVALID_TOKEN(401, "RAEL.C031", "유효한 토큰이 아님"),


    //Omni SDK 블록체인 오류
    OMNI_BLOCKCHAIN_EXCEPTION(400, "RAEL.B001","블록체인 연계 오류"),
    OMNI_SDK_EXCEPTION(400, "RAEL.B002","OMNI SDK 오류"),
    OMNI_BLOCKCHAIN_RESULT_FALSE(400, "RAEL.B003","블록체인 등록 결과 실패"),



    // Issuer
    LIL_EXCEPTION(400, "RDIS.I001", "LIL 연계에 실패"),

    INVALID_SCHEMA_DUPLICATED(400, "RDIS.S001", "등록된 스키마가 존재 (스키마 코드와 버전)"),
    SCHEMA_NOT_FOUNDED(400, "RDIS.S002", "스키마 없음"),
    INVALID_SCHEMA_STATUS(400, "RDIS.S003", "유효하지 않은 스키마 상태"),

    INVALID_VCDEF_DUPLICATED(400, "RDIS.V001", "등록된 VC DEF 가 존재 (schema id)"),
    VCDEF_NOT_FOUNDED(400, "RDIS.V002", "VC DEF 없음"),
    VCDEF_MAX_COUNT_OVERFLOW(400, "RDIS.V003", "등록 가능한 최대 갯수 초과 (max: 675)"),
    INVALID_VCDEF_STATUS(400, "RDIS.V004", "유효하지 않은 VC DEF 상태"),
    VCDEF_MAPPING_NOT_FOUND(400, "RDIS.V005", "등록된 VC DEF 매핑 정보 없음"),

    INVALID_ISSUE_VC(400, "RDIS.C001", "VC 발급실패"),



    // Verifier
    IDP_ACCOUNT_NOT_FOUND(400, "RDVS.E001", "IDP 계정 정보 없음"),
    INVALID_VCTN_RULE_DUPLICATED(400, "RDVS.V001", "등록된 VCTN RULE 이 존재 (verificationRuleCode)"),
    VCTN_RULE_NOT_FOUNDED(400, "RDVS.V002", "VCTN RULE 없음"),
    INVALID_VCTN_RULE_STATUS(400, "RDVS.V003", "유효하지 않은 VCTN RULE 상태"),
    QR_DATA_NOT_FOUNDED(400, "RDVS.Q001", "QR DATA 없거나 SERVER NONCE 값 일치하지 않음"),
    INVALID_QR_DATA_TIMEOUT(400, "RDVS.Q002", "QR DATA 유효기간 만료"),
    INVALID_QR_DATA_STATUS(400, "RDVS.Q003", "유효하지 않은 검증 상태"),
    FAIL_QR_DATA_SAVE(400, "RDVS.Q004", "QR DATA 를 DB에 저장하는데 실패"),
    FAIL_VCTN_HISTORY_SAVE(400, "RDVS.Q005", "검증 이력을 DB에 저장하는데 실패");




    private final String code;
    private String message;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setErrorStatus(final int status, final String message){
        this.status = status;
        this.message = message;
    }
}
