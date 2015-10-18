	.file	"create_process.c"
	.text
.Ltext0:
	.globl	bin
	.data
	.type	bin, @object
	.size	bin, 3
bin:
	.string	"ls"
	.section	.rodata
.LC0:
	.string	"Command Processor available!"
	.align 8
.LC1:
	.string	"Create process with system(...), output is: \n"
	.align 8
.LC2:
	.string	"Process creation successful. Return code: %i\n"
	.align 8
.LC3:
	.string	"Process creation failed. Return code: %i\n"
.LC4:
	.string	"The current PID is %ld\n"
.LC5:
	.string	"The parent PID is %ld\n"
	.align 8
.LC6:
	.string	"Call to pid, didn't succeed - pid = %ld\n"
	.align 8
.LC7:
	.string	"Child: Entering the child code path - pid = %ld\n"
.LC8:
	.string	"Child: parent pid is %ld\n"
.LC9:
	.string	"Child: Try changing to ls: \n"
.LC10:
	.string	"-v"
.LC11:
	.string	"ls"
	.align 8
.LC12:
	.string	"\nChild: Changed executing program to ls!"
	.align 8
.LC13:
	.string	"Child: Error while changing executing program to ls!"
.LC14:
	.string	"Child: Error is %s\n"
.LC15:
	.string	"Child: Finished!"
.LC16:
	.string	"Parent: Waiting for child!"
	.align 8
.LC17:
	.string	"Parent: waitpid set the status pointer to %i\n"
.LC18:
	.string	"Parent: WIFEXITED is %i\n"
	.align 8
.LC19:
	.string	"The child process terminated normally."
	.align 8
.LC20:
	.string	"The child process didn't terminate normally."
	.align 8
.LC21:
	.string	"Parent: Entering the parent code path - pid %ld\n"
	.align 8
.LC22:
	.string	"No Command Processor available!"
	.text
	.globl	runCreateProcess
	.type	runCreateProcess, @function
runCreateProcess:
.LFB2:
	.file 1 "processes/create_process.c"
	.loc 1 22 0
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	subq	$64, %rsp
	.loc 1 25 0
	movl	$0, %edi
	call	system
	movl	%eax, -56(%rbp)
	.loc 1 26 0
	cmpl	$0, -56(%rbp)
	jle	.L2
.LBB2:
	.loc 1 27 0
	movl	$.LC0, %edi
	call	puts
	.loc 1 30 0
	movl	$.LC1, %edi
	call	puts
	.loc 1 31 0
	movl	$0, %eax
	call	createProcess
	movl	%eax, -52(%rbp)
	.loc 1 32 0
	movl	$10, %edi
	call	putchar
	.loc 1 33 0
	cmpl	$0, -52(%rbp)
	jne	.L3
	.loc 1 34 0
	movl	-52(%rbp), %eax
	movl	%eax, %esi
	movl	$.LC2, %edi
	movl	$0, %eax
	call	printf
	jmp	.L4
.L3:
	.loc 1 36 0
	movl	-52(%rbp), %eax
	movl	%eax, %esi
	movl	$.LC3, %edi
	movl	$0, %eax
	call	printf
.L4:
	.loc 1 40 0
	call	getpid
	movl	%eax, -48(%rbp)
	.loc 1 41 0
	movl	-48(%rbp), %eax
	movl	%eax, %esi
	movl	$.LC4, %edi
	movl	$0, %eax
	call	printf
	.loc 1 43 0
	call	getppid
	movl	%eax, -44(%rbp)
	.loc 1 44 0
	movl	-44(%rbp), %eax
	movl	%eax, %esi
	movl	$.LC5, %edi
	movl	$0, %eax
	call	printf
	.loc 1 47 0
	call	fork
	movl	%eax, -48(%rbp)
	.loc 1 48 0
	cmpl	$0, -48(%rbp)
	jns	.L5
	.loc 1 49 0
	movl	-48(%rbp), %eax
	movl	%eax, %esi
	movl	$.LC6, %edi
	movl	$0, %eax
	call	printf
	jmp	.L1
.L5:
	.loc 1 50 0
	cmpl	$0, -48(%rbp)
	jne	.L7
.LBB3:
	.loc 1 51 0
	movl	-48(%rbp), %eax
	movl	%eax, %esi
	movl	$.LC7, %edi
	movl	$0, %eax
	call	printf
	.loc 1 53 0
	call	getppid
	movl	%eax, %esi
	movl	$.LC8, %edi
	movl	$0, %eax
	call	printf
	.loc 1 55 0
	movl	$.LC9, %edi
	call	puts
	.loc 1 56 0
	movq	$.LC10, -16(%rbp)
	movq	$0, -8(%rbp)
	.loc 1 57 0
	leaq	-16(%rbp), %rax
	movq	%rax, %rsi
	movl	$.LC11, %edi
	call	execvp
	movl	%eax, -40(%rbp)
	.loc 1 58 0
	cmpl	$0, -40(%rbp)
	jne	.L8
	.loc 1 59 0
	movl	$.LC12, %edi
	call	puts
	jmp	.L9
.L8:
	.loc 1 61 0
	movl	$.LC13, %edi
	call	puts
	.loc 1 62 0
	call	__errno_location
	movl	(%rax), %eax
	movl	%eax, %edi
	call	strerror
	movq	%rax, %rsi
	movl	$.LC14, %edi
	movl	$0, %eax
	call	printf
.L9:
	.loc 1 66 0
	movl	$.LC15, %edi
	call	puts
	.loc 1 67 0
	movl	$0, %edi
	call	exit
.L7:
.LBE3:
.LBB4:
	.loc 1 69 0
	movl	$.LC16, %edi
	call	puts
	.loc 1 71 0
	leaq	-16(%rbp), %rcx
	movl	-48(%rbp), %eax
	movl	$0, %edx
	movq	%rcx, %rsi
	movl	%eax, %edi
	call	waitpid
	.loc 1 72 0
	movq	-16(%rbp), %rax
	movq	%rax, %rsi
	movl	$.LC17, %edi
	movl	$0, %eax
	call	printf
	.loc 1 73 0
	movq	-16(%rbp), %rax
	movq	%rax, -32(%rbp)
	movl	-32(%rbp), %eax
	andl	$127, %eax
	testl	%eax, %eax
	sete	%al
	movzbl	%al, %eax
	movl	%eax, -36(%rbp)
	.loc 1 74 0
	movl	-36(%rbp), %eax
	movl	%eax, %esi
	movl	$.LC18, %edi
	movl	$0, %eax
	call	printf
	.loc 1 75 0
	cmpl	$0, -36(%rbp)
	jle	.L10
	.loc 1 76 0
	movl	$.LC19, %edi
	call	puts
	jmp	.L11
.L10:
	.loc 1 78 0
	movl	$.LC20, %edi
	call	puts
.L11:
	.loc 1 80 0 discriminator 1
	movl	-48(%rbp), %eax
	movl	%eax, %esi
	movl	$.LC21, %edi
	movl	$0, %eax
	call	printf
.LBE4:
.LBE2:
	jmp	.L1
.L2:
	.loc 1 83 0
	movl	$.LC22, %edi
	call	puts
.L1:
	.loc 1 85 0
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE2:
	.size	runCreateProcess, .-runCreateProcess
	.globl	createProcess
	.type	createProcess, @function
createProcess:
.LFB3:
	.loc 1 90 0
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	.loc 1 91 0
	movl	$bin, %edi
	call	system
	.loc 1 92 0
	popq	%rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE3:
	.size	createProcess, .-createProcess
.Letext0:
	.file 2 "/usr/include/x86_64-linux-gnu/bits/types.h"
	.file 3 "/usr/include/x86_64-linux-gnu/sys/types.h"
	.section	.debug_info,"",@progbits
.Ldebug_info0:
	.long	0x1bc
	.value	0x4
	.long	.Ldebug_abbrev0
	.byte	0x8
	.uleb128 0x1
	.long	.LASF18
	.byte	0x1
	.long	.LASF19
	.long	.LASF20
	.quad	.Ltext0
	.quad	.Letext0-.Ltext0
	.long	.Ldebug_line0
	.uleb128 0x2
	.byte	0x8
	.byte	0x7
	.long	.LASF0
	.uleb128 0x3
	.byte	0x4
	.byte	0x5
	.string	"int"
	.uleb128 0x2
	.byte	0x1
	.byte	0x8
	.long	.LASF1
	.uleb128 0x2
	.byte	0x2
	.byte	0x7
	.long	.LASF2
	.uleb128 0x2
	.byte	0x4
	.byte	0x7
	.long	.LASF3
	.uleb128 0x2
	.byte	0x1
	.byte	0x6
	.long	.LASF4
	.uleb128 0x2
	.byte	0x2
	.byte	0x5
	.long	.LASF5
	.uleb128 0x2
	.byte	0x8
	.byte	0x5
	.long	.LASF6
	.uleb128 0x4
	.long	.LASF10
	.byte	0x2
	.byte	0x85
	.long	0x34
	.uleb128 0x2
	.byte	0x8
	.byte	0x7
	.long	.LASF7
	.uleb128 0x5
	.byte	0x8
	.long	0x7d
	.uleb128 0x2
	.byte	0x1
	.byte	0x6
	.long	.LASF8
	.uleb128 0x5
	.byte	0x8
	.long	0x34
	.uleb128 0x2
	.byte	0x8
	.byte	0x5
	.long	.LASF9
	.uleb128 0x4
	.long	.LASF11
	.byte	0x3
	.byte	0x62
	.long	0x65
	.uleb128 0x2
	.byte	0x8
	.byte	0x7
	.long	.LASF12
	.uleb128 0x6
	.long	.LASF21
	.byte	0x1
	.byte	0x16
	.quad	.LFB2
	.quad	.LFE2-.LFB2
	.uleb128 0x1
	.byte	0x9c
	.long	0x16d
	.uleb128 0x7
	.string	"res"
	.byte	0x1
	.byte	0x19
	.long	0x34
	.uleb128 0x3
	.byte	0x91
	.sleb128 -72
	.uleb128 0x8
	.quad	.LBB2
	.quad	.LBE2-.LBB2
	.uleb128 0x9
	.long	.LASF13
	.byte	0x1
	.byte	0x1f
	.long	0x34
	.uleb128 0x3
	.byte	0x91
	.sleb128 -68
	.uleb128 0x7
	.string	"pid"
	.byte	0x1
	.byte	0x28
	.long	0x91
	.uleb128 0x2
	.byte	0x91
	.sleb128 -64
	.uleb128 0x9
	.long	.LASF14
	.byte	0x1
	.byte	0x2b
	.long	0x91
	.uleb128 0x2
	.byte	0x91
	.sleb128 -60
	.uleb128 0xa
	.quad	.LBB3
	.quad	.LBE3-.LBB3
	.long	0x13d
	.uleb128 0x9
	.long	.LASF15
	.byte	0x1
	.byte	0x38
	.long	0x16d
	.uleb128 0x2
	.byte	0x91
	.sleb128 -32
	.uleb128 0x7
	.string	"res"
	.byte	0x1
	.byte	0x39
	.long	0x34
	.uleb128 0x2
	.byte	0x91
	.sleb128 -56
	.byte	0
	.uleb128 0x8
	.quad	.LBB4
	.quad	.LBE4-.LBB4
	.uleb128 0x9
	.long	.LASF16
	.byte	0x1
	.byte	0x46
	.long	0x84
	.uleb128 0x2
	.byte	0x91
	.sleb128 -32
	.uleb128 0x9
	.long	.LASF17
	.byte	0x1
	.byte	0x49
	.long	0x34
	.uleb128 0x2
	.byte	0x91
	.sleb128 -52
	.byte	0
	.byte	0
	.byte	0
	.uleb128 0xb
	.long	0x77
	.long	0x17d
	.uleb128 0xc
	.long	0x70
	.byte	0x1
	.byte	0
	.uleb128 0xd
	.long	.LASF22
	.byte	0x1
	.byte	0x5a
	.long	0x34
	.quad	.LFB3
	.quad	.LFE3-.LFB3
	.uleb128 0x1
	.byte	0x9c
	.uleb128 0xb
	.long	0x7d
	.long	0x1aa
	.uleb128 0xc
	.long	0x70
	.byte	0x2
	.byte	0
	.uleb128 0xe
	.string	"bin"
	.byte	0x1
	.byte	0xd
	.long	0x19a
	.uleb128 0x9
	.byte	0x3
	.quad	bin
	.byte	0
	.section	.debug_abbrev,"",@progbits
.Ldebug_abbrev0:
	.uleb128 0x1
	.uleb128 0x11
	.byte	0x1
	.uleb128 0x25
	.uleb128 0xe
	.uleb128 0x13
	.uleb128 0xb
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x1b
	.uleb128 0xe
	.uleb128 0x11
	.uleb128 0x1
	.uleb128 0x12
	.uleb128 0x7
	.uleb128 0x10
	.uleb128 0x17
	.byte	0
	.byte	0
	.uleb128 0x2
	.uleb128 0x24
	.byte	0
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x3e
	.uleb128 0xb
	.uleb128 0x3
	.uleb128 0xe
	.byte	0
	.byte	0
	.uleb128 0x3
	.uleb128 0x24
	.byte	0
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x3e
	.uleb128 0xb
	.uleb128 0x3
	.uleb128 0x8
	.byte	0
	.byte	0
	.uleb128 0x4
	.uleb128 0x16
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x5
	.uleb128 0xf
	.byte	0
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x6
	.uleb128 0x2e
	.byte	0x1
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x11
	.uleb128 0x1
	.uleb128 0x12
	.uleb128 0x7
	.uleb128 0x40
	.uleb128 0x18
	.uleb128 0x2116
	.uleb128 0x19
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x7
	.uleb128 0x34
	.byte	0
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x2
	.uleb128 0x18
	.byte	0
	.byte	0
	.uleb128 0x8
	.uleb128 0xb
	.byte	0x1
	.uleb128 0x11
	.uleb128 0x1
	.uleb128 0x12
	.uleb128 0x7
	.byte	0
	.byte	0
	.uleb128 0x9
	.uleb128 0x34
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x2
	.uleb128 0x18
	.byte	0
	.byte	0
	.uleb128 0xa
	.uleb128 0xb
	.byte	0x1
	.uleb128 0x11
	.uleb128 0x1
	.uleb128 0x12
	.uleb128 0x7
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0xb
	.uleb128 0x1
	.byte	0x1
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0xc
	.uleb128 0x21
	.byte	0
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x2f
	.uleb128 0xb
	.byte	0
	.byte	0
	.uleb128 0xd
	.uleb128 0x2e
	.byte	0
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x11
	.uleb128 0x1
	.uleb128 0x12
	.uleb128 0x7
	.uleb128 0x40
	.uleb128 0x18
	.uleb128 0x2116
	.uleb128 0x19
	.byte	0
	.byte	0
	.uleb128 0xe
	.uleb128 0x34
	.byte	0
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x2
	.uleb128 0x18
	.byte	0
	.byte	0
	.byte	0
	.section	.debug_aranges,"",@progbits
	.long	0x2c
	.value	0x2
	.long	.Ldebug_info0
	.byte	0x8
	.byte	0
	.value	0
	.value	0
	.quad	.Ltext0
	.quad	.Letext0-.Ltext0
	.quad	0
	.quad	0
	.section	.debug_line,"",@progbits
.Ldebug_line0:
	.section	.debug_str,"MS",@progbits,1
.LASF9:
	.string	"long long int"
.LASF3:
	.string	"unsigned int"
.LASF18:
	.string	"GNU C 4.8.4 -mtune=generic -march=x86-64 -g -fstack-protector"
.LASF0:
	.string	"long unsigned int"
.LASF21:
	.string	"runCreateProcess"
.LASF16:
	.string	"statusPtr"
.LASF13:
	.string	"resCreate"
.LASF8:
	.string	"char"
.LASF12:
	.string	"long long unsigned int"
.LASF1:
	.string	"unsigned char"
.LASF19:
	.string	"processes/create_process.c"
.LASF6:
	.string	"long int"
.LASF14:
	.string	"ppid"
.LASF22:
	.string	"createProcess"
.LASF17:
	.string	"normExit"
.LASF2:
	.string	"short unsigned int"
.LASF4:
	.string	"signed char"
.LASF15:
	.string	"params"
.LASF20:
	.string	"/home/uli/Dokumente/IT/Entwicklung/NetBeansProjects/Kaputnik120/C-Standard/CStandard"
.LASF5:
	.string	"short int"
.LASF10:
	.string	"__pid_t"
.LASF7:
	.string	"sizetype"
.LASF11:
	.string	"pid_t"
	.ident	"GCC: (Ubuntu 4.8.4-2ubuntu1~14.04) 4.8.4"
	.section	.note.GNU-stack,"",@progbits
