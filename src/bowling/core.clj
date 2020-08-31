(ns bowling.core
  (:gen-class))

(defn group-frames [rolls]
  (partition 2 rolls)
  )

(defn to-frame-scores [frames]
  (map #(reduce + %) frames))

(defn score [rolls]
  (reduce + (to-frame-scores (group-frames rolls))))