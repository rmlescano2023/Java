if (choosePattern == 0) {           // Shows what pattern will be used for the round
            pattern = execute.randomizePattern(cardValues, random, bingoNum);

            switch(pattern) {
                case 0: patternLabel.setText("Pattern: Four Corners");      break;
                case 1: patternLabel.setText("Pattern: Straight Across");   break;
                case 2: patternLabel.setText("Pattern: Straight Down");     break;
            }
            choosePattern = 1;
        }