package cn.myperf4j.base.metric.exporter.log;

import cn.myperf4j.base.config.ProfilingConfig;
import cn.myperf4j.base.log.ILogger;
import cn.myperf4j.base.log.LoggerFactory;
import cn.myperf4j.base.metric.exporter.JvmGcMetricsV3Exporter;

/**
 * Created by LinShunkang on 2024/02/08
 */
public abstract class AbstractLogJvmGcMetricsV3Exporter implements JvmGcMetricsV3Exporter {

    protected ILogger logger = LoggerFactory.getLogger(ProfilingConfig.metricsConfig().gcMetricsFile());

    @Override
    public void beforeProcess(long processId, long startMillis, long stopMillis) {
        //empty
    }

    @Override
    public void afterProcess(long processId, long startMillis, long stopMillis) {
        logger.flushLog();
    }
}
