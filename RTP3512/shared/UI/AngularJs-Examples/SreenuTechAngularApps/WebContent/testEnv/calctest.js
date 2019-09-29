describe("calculator test",function(){
	describe("add testing", function(){
		it("1+1 should be equal to 2",function(){
			expect(calculator.add(1,1)).toBe(2);
		});
	});
	
	
	describe("sub testing",function(){
		it("1-1 should be equal to 0",function(){
			expect(calculator.sub(1,1)).toBe(10);
		});
	});
	
	
});