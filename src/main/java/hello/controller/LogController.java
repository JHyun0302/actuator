package hello.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 실시간 로그 레벨 변경
 * 1. Postman 설정 (Post, JSON)
 * 2. body 내용 ({ "configuredLevel" : "Trace" })
 * 3. 결과 : 로그 레벨 Trace로 변경
 */
@Slf4j
@RestController
public class LogController {
    @GetMapping("/log")
    public String log() {
        log.trace("trace log");
        log.debug("debug log");
        log.info("info log");
        log.warn("war log");
        log.error("error log");
        return "ok";
    }
}
