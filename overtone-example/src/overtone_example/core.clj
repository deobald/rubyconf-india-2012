(ns overtone-example.core)

;; (use 'overtone.live)

(use 'overtone.core)

(defn fuck []
  (boot-external-server)
  (demo 5 (pan2 (sin-osc 440))))