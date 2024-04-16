function maxAdjacentSum(arr) {
    let maxSum = 0;
  
    for (let i = 0; i < arr.length - 1; i++) {
      const currentSum = arr[i] + arr[i + 1];
      if (currentSum > maxSum) {
        maxSum = currentSum;
      }
    }
  
    return maxSum;
  }
  
  // Ejemplo de uso
  const numbers = [3, 6, -2, -5, 7, 8];
  const maxSum = maxAdjacentSum(numbers);
  console.log(maxSum); // Output: 10