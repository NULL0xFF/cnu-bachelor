.section .data
scanf_format:
	.string "%d"
printf_format:
	.string "your : %d \n"
input :
	.int 0

.section .text
.global main

main:
	#call function scanf
	#scanf("%d", &input);
	movq	$scanf_format, %rdi
	movq	$input, %rsi
	movq	$0, %rax
	call	scanf

	#call function printf
	#printf("your : %d \n", input);
	movq	$printf_format, %rdi
	movq	input, %rsi
	movq	$0, %rax
	call	printf

	ret
