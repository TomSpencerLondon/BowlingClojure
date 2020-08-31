(ns bowling.core
  (:gen-class))


(defn next-frame-size [remaining-rolls]
  (if (= 3 (count remaining-rolls))
    3
    (if (= 10 (first remaining-rolls))
      1
      2)))

(defn group-frames [rolls]
  (loop [remaining rolls
         frames []]
    (if (empty? remaining)
      frames
      (let [size (next-frame-size remaining)]
        (recur (drop size remaining)
               (conj frames (take size remaining)))))))

(defn spare? [frame]
  (and (= 10 (reduce + frame))
       (= 2 (count frame))))

(defn spare-extra-score [remaining-frames]
  (first (first remaining-frames)))

(defn strike-extra-score [remaining-frames]
  (reduce + (take 2 (flatten remaining-frames))))

(defn next-frame-score [[frame & other]]
  (let [simple-score (reduce + frame)]
    (if (= 10 (first frame))
      (+ simple-score (strike-extra-score other))
      (if (spare? frame)
        (+ simple-score (spare-extra-score other))
        simple-score))))

(defn to-frame-scores [frames]
  (loop [remaining frames
         scores []]

    (if (empty? remaining)
      scores
      (recur (rest remaining)
             (conj scores (next-frame-score remaining))))))

(defn score [rolls]
  (reduce + (to-frame-scores (group-frames rolls))))