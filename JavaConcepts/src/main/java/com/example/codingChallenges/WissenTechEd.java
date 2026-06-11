package com.example.codingChallenges;

import java.io.IOException;
import java.net.SocketException;

enum RetryStrategy {
    Linear,
    Constant,
    Expo
}

interface RetryActivities {
    String retry(Runnable task, int maxRetries, int delay, RetryStrategy st);
}

class TerminalException extends RuntimeException {
    public TerminalException(Throwable cause) {
        super(cause);
    }
}

public class WissenTechEd {

    static RetryActivities retryHandler = (task, maxRetries, delay, st) -> {

        int currentDelay = delay;

        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                task.run();
                return "Success on attempt " + attempt;

            } catch (TerminalException e) {
                // --- Terminal — stop immediately ---
                System.out.println("Terminal error: " + e.getCause().getClass().getSimpleName()
                        + " — " + e.getCause().getMessage());
                System.out.println("Terminating program.");
                System.exit(1);

            } catch (RuntimeException e) {
                // --- Retryable — continue ---
                System.out.println("Attempt " + attempt + " failed (retryable): " + e.getMessage());

                if (attempt == maxRetries) {
                    return "Failed after " + maxRetries + " attempts.";
                }

                switch (st) {
                    case Constant: currentDelay = delay; break;
                    case Linear:   currentDelay = delay * attempt; break;
                    case Expo:     currentDelay = (int) (delay * Math.pow(2, attempt - 1)); break;
                }

                try {
                    Thread.sleep(currentDelay);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    return "Interrupted during retry.";
                }
            }
        }

        return "Unexpected end of retry loop.";
    };

    public static void main(String[] args) {

        // --- Test 1: Retryable exception ---
        System.out.println("=== Test 1: Retryable Exception ===");
        final int[] callCount = {0};

        String result1 = retryHandler.retry(
            () -> {
                callCount[0]++;
                if (callCount[0] < 3) {
                    throw new RuntimeException("Transient failure #" + callCount[0]);
                }
                System.out.println("Task completed successfully.");
            },
            5, 500, RetryStrategy.Linear
        );
        System.out.println("Result: " + result1);

        // --- Test 2: Terminal IOException ---
        System.out.println("\n=== Test 2: Terminal IOException ===");

        retryHandler.retry(
            () -> {
                try {
                    throw new IOException("Disk not found");
                } catch (IOException e) {
                    throw new TerminalException(e);
                }
            },
            5, 500, RetryStrategy.Expo
        );

        // --- Test 3: Terminal SocketException ---
        System.out.println("\n=== Test 3: Terminal SocketException ===");

        retryHandler.retry(
            () -> {
                try {
                    throw new SocketException("Port unreachable");
                } catch (SocketException e) {
                    throw new TerminalException(e);
                }
            },
            5, 500, RetryStrategy.Constant
        );
    }
}