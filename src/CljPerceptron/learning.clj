(ns CljPerceptron.learning)
(use 'CljPerceptron.perceptron)

;(defn train-perceptron [p learning-set learning-rate iterations]
  ;"Uses a very basic algorithm to produce a 'learned' perceptron using 
  ;the given perceptron, a learning set which is a list containing a list
  ;of input values and an expected output,a learning rate between 0 and 1
  ;and a maximum number of iterations."
  ;(let [new-p
   ;(loop [p p learning-set learning-set learning-rate learning-rate]
    ;(let 
        ;[weights (get (meta p) :weights)
         ;input (first (first learning-set))
         ;expected-out (first (rest (first learning-set)))
         ;actual-out (p input)
         ;new-weights (map (fn [w,x] (+ w (* learning-rate (- expected-out actual-out) x))) weights input)
         ;new-p (make-perceptron (get (meta p) :bias) new-weights (get (meta p) :threshold))]
         ;
      ;(do (println new-weights)
         ;(if (not (empty? learning-set))
           ;(recur new-p (rest learning-set) learning-rate)
           ;p))))]
    ;(if (= iterations 0)
      ;new-p
      ;(do
        ;(recur new-p learning-set learning-rate (- iterations 1))))))

(defn train-perceptron [p learning-set learning-rate]
  (if (empty? learning-set)
    p
  (let 
      [weights (get (meta p) :weights)
       input (first (first learning-set))
       expected-out (second (first learning-set))
       actual-out (p input)
       error (- actual-out expected-out )
       new-weights (map (fn [w,x] (do 
                                    ;(println w) 
                                    ;(println x) 
                                    (+ w (* learning-rate error x)))) weights input)
       new-p (make-perceptron (get (meta p) :bias) new-weights (get (meta p) :threshold))]
    (do
      (println error)
      (println new-weights)
    (recur new-p (rest learning-set) learning-rate))
      
     )))

