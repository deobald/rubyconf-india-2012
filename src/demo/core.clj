(ns demo.core)

(comment
  ;; C-) slurp
  ;; C-} barf
  ;; M-S split
  ;; M-J join
  (a b c (w x y z) 1 2 3))

;; ---------------------------------------------------------------

(defn organizers [staff attendees]
  (let [is-staff? (fn [a] (some #{a} staff))]
    (filter is-staff? attendees)))

(organizers ["ajey" "judy" "niranjan"]
            ["headius" "mikel" "niranjan" "tejas" "jasim"
             "matthew" "abhishek" "ravindra" "ajey"
             "habibullah" "chandan" "steven" "darshan" "manu"
             "gautam" "shabbir" "arpan" "chang" "arun"
             "karunakar" "shailesh" "sandip" "nikhil"
             "shishir" "rocky" "arun"])

;; ---------------------------------------------------------------

(def smit (agent {:kills 0}))

(defn kill [a]
  (Thread/sleep 5000)
  {:kills (+ (:kills a) 1)})

(defn instruct-to-kill []
  (send smit kill))

;; (restart-agent smit {:kills 0})