(ns CljPerceptron.util)

(defn abs [n]
"absolute value"
  (if (< n 0)
    (* n -1)
    n))

(defn dot-product [v1 v2]
"produces dot product of two vectors"
  (reduce + (map * v1 v2)))


