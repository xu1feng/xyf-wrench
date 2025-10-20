package edu.xyf.wrench.task.job;

import edu.xyf.wrench.task.job.config.TaskJobAutoProperties;
import edu.xyf.wrench.task.job.service.ITaskJobService;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Author: Xuyifeng
 * @Description: 任务调度作业 - 定时获取有效的任务调度配置，并动态创建新的任务
 * @Date: 2025/10/20 14:35
 */

public class TaskJob {

    private final TaskJobAutoProperties properties;
    private final ITaskJobService taskJobService;

    public TaskJob(TaskJobAutoProperties properties, ITaskJobService taskJobService) {
        this.properties = properties;
        this.taskJobService = taskJobService;
    }

    /**
     * 定时刷新任务调度配置
     */
    @Scheduled(fixedRateString = "${xyf.wrench.task.job.refresh-interval:60000}")
    public void refreshTasks() {
        if (!properties.isEnabled()) {
            return;
        }
        taskJobService.refreshTasks();
    }

    /**
     * 定时清理无效任务
     */
    @Scheduled(cron = "${xyf.wrench.task.job.clean-invalid-tasks-cron:0 0/10 * * * ?}")
    public void cleanInvalidTasks() {
        if (!properties.isEnabled()) {
            return;
        }
        taskJobService.cleanInvalidTasks();
    }

}
