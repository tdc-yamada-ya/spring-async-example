package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 非同期処理を効率的に行うための設定を行います。
 */
@Configuration
public class AsyncConfig {
    /**
     * 通常の非同期処理に使用する {@link Executor} を生成します。
     * {@link org.springframework.scheduling.annotation.Async} アノテーションに何も指定しない場合、これを使用します。
     *
     * @return 非同期処理の {@link Executor}
     */
    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // 常に待機させるスレッド数 10、最大スレッド数 50、スレッドが埋まっているときの待機キューサイズ 10
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(10);

        executor.setThreadNamePrefix("myApp-");

        executor.initialize();

        return executor;
    }
}
