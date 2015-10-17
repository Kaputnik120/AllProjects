	.file	"create_process.c"
	.text
.Ltext0:
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
	.string	"Child: Finished!"
.LC10:
	.string	"Parent: Waiting for child!"
	.align 8
.LC11:
	.string	"Parent: waitpid set the status pointer to %i\n"
.LC12:
	.string	"Parent: WIFEXITED is %i\n"
	.align 8
.LC13:
	.string	"The child process terminated normally."
	.align 8
.LC14:
	.string	"The child process didn't terminate normally."
	.align 8
.LC15:
	.string	"Parent: Entering the parent code path - pid %ld\n"
	.align 8
.LC16:
	.string	"No Command Processor available!"
	.text
	.globl	runCreateProcess
	.type	runCreateProcess, @function
runCreateProcess:
.LFB2:
	.file 1 "processes/create_process.c"
	.loc 1 13 0
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	subq	$48, %rsp
	.loc 1 16 0
	movl	$0, %edi
	call	system
	movl	%eax, -36(%rbp)
	.loc 1 17 0
	cmpl	$0, -36(%rbp)
	jle	.L2
.LBB2:
	.loc 1 18 0
	movl	$.LC0, %edi
	call	puts
	.loc 1 21 0
	movl	$.LC1, %edi
	call	puts
	.loc 1 22 0
	movl	$0, %eax
	call	createProcess
	movl	%eax, -32(%rbp)
	.loc 1 23 0
	movl	$10, %edi
	call	putchar
	.loc 1 24 0
	cmpl	$0, -32(%rbp)
	jne	.L3
	.loc 1 25 0
	movl	-32(%rbp), %eax
	movl	%eax, %esi
	movl	$.LC2, %edi
	movl	$0, %eax
	call	printf
	jmp	.L4
.L3:
	.loc 1 27 0
	movl	-32(%rbp), %eax
	movl	%eax, %esi
	movl	$.LC3, %edi
	movl	$0, %eax
	call	printf
.L4:
	.loc 1 31 0
	call	getpid
	movl	%eax, -28(%rbp)
	.loc 1 32 0
	movl	-28(%rbp), %eax
	movl	%eax, %esi
	movl	$.LC4, %edi
	movl	$0, %eax
	call	printf
	.loc 1 34 0
	call	getppid
	movl	%eax, -24(%rbp)
	.loc 1 35 0
	movl	-24(%rbp), %eax
	movl	%eax, %esi
	movl	$.LC5, %edi
	movl	$0, %eax
	call	printf
	.loc 1 38 0
	call	fork
	movl	%eax, -28(%rbp)
	.loc 1 39 0
	cmpl	$0, -28(%rbp)
	jns	.L5
	.loc 1 40 0
	movl	-28(%rbp), %eax
	movl	%eax, %esi
	movl	$.LC6, %edi
	movl	$0, %eax
	call	printf
	jmp	.L1
.L5:
	.loc 1 41 0
	cmpl	$0, -28(%rbp)
	jne	.L7
	.loc 1 43 0
	movl	-28(%rbp), %eax
	movl	%eax, %esi
	movl	$.LC7, %edi
	movl	$0, %eax
	call	printf
	.loc 1 45 0
	call	getppid
	movl	%eax, %esi
	movl	$.LC8, %edi
	movl	$0, %eax
	call	printf
	.loc 1 47 0
	movl	$.LC9, %edi
	call	puts
	.loc 1 48 0
	movl	$0, %edi
	call	exit
.L7:
.LBB3:
	.loc 1 50 0
	movl	$.LC10, %edi
	call	puts
	.loc 1 52 0
	leaq	-8(%rbp), %rcx
	movl	-28(%rbp), %eax
	movl	$0, %edx
	movq	%rcx, %rsi
	movl	%eax, %edi
	call	waitpid
	.loc 1 53 0
	movq	-8(%rbp), %rax
	movq	%rax, %rsi
	movl	$.LC11, %edi
	movl	$0, %eax
	call	printf
	.loc 1 54 0
	movq	-8(%rbp), %rax
	movq	%rax, -16(%rbp)
	movl	-16(%rbp), %eax
	andl	$127, %eax
	testl	%eax, %eax
	sete	%al
	movzbl	%al, %eax
	movl	%eax, -20(%rbp)
	.loc 1 55 0
	movl	-20(%rbp), %eax
	movl	%eax, %esi
	movl	$.LC12, %edi
	movl	$0, %eax
	call	printf
	.loc 1 56 0
	cmpl	$0, -20(%rbp)
	jle	.L8
	.loc 1 57 0
	movl	$.LC13, %edi
	call	puts
	jmp	.L9
.L8:
	.loc 1 59 0
	movl	$.LC14, %edi
	call	puts
.L9:
	.loc 1 61 0 discriminator 1
	movl	-28(%rbp), %eax
	movl	%eax, %esi
	movl	$.LC15, %edi
	movl	$0, %eax
	call	printf
.LBE3:
.LBE2:
	jmp	.L1
.L2:
	.loc 1 64 0
	movl	$.LC16, %edi
	call	puts
.L1:
	.loc 1 66 0
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE2:
	.size	runCreateProcess, .-runCreateProcess
	.section	.rodata
.LC17:
	.string	"ls"
	.text
	.globl	createProcess
	.type	createProcess, @function
createProcess:
.LFB3:
	.loc 1 71 0
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	.loc 1 73 0
	movl	$.LC17, %edi
	call	system
	.loc 1 78 0
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
	.long	0x14d
	.value	0x4
	.long	.Ldebug_abbrev0
	.byte	0x8
	.uleb128 0x1
	.long	.LASF17
	.byte	0x1
	.long	.LASF18
	.long	.LASF19
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
	.long	.LASF20
	.byte	0x1
	.byte	0xd
	.quad	.LFB2
	.quad	.LFE2-.LFB2
	.uleb128 0x1
	.byte	0x9c
	.long	0x133
	.uleb128 0x7
	.string	"res"
	.byte	0x1
	.byte	0x10
	.long	0x34
	.uleb128 0x2
	.byte	0x91
	.sleb128 -52
	.uleb128 0x8
	.quad	.LBB2
	.quad	.LBE2-.LBB2
	.uleb128 0x9
	.long	.LASF13
	.byte	0x1
	.byte	0x16
	.long	0x34
	.uleb128 0x2
	.byte	0x91
	.sleb128 -48
	.uleb128 0x7
	.string	"pid"
	.byte	0x1
	.byte	0x1f
	.long	0x8b
	.uleb128 0x2
	.byte	0x91
	.sleb128 -44
	.uleb128 0x9
	.long	.LASF14
	.byte	0x1
	.byte	0x22
	.long	0x8b
	.uleb128 0x2
	.byte	0x91
	.sleb128 -40
	.uleb128 0x8
	.quad	.LBB3
	.quad	.LBE3-.LBB3
	.uleb128 0x9
	.long	.LASF15
	.byte	0x1
	.byte	0x33
	.long	0x7e
	.uleb128 0x2
	.byte	0x91
	.sleb128 -24
	.uleb128 0x9
	.long	.LASF16
	.byte	0x1
	.byte	0x36
	.long	0x34
	.uleb128 0x2
	.byte	0x91
	.sleb128 -36
	.byte	0
	.byte	0
	.byte	0
	.uleb128 0xa
	.long	.LASF21
	.byte	0x1
	.byte	0x47
	.long	0x34
	.quad	.LFB3
	.quad	.LFE3-.LFB3
	.uleb128 0x1
	.byte	0x9c
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
.LASF17:
	.string	"GNU C 4.8.4 -mtune=generic -march=x86-64 -g -fstack-protector"
.LASF19:
	.string	"/home/uli/Dokumente/IT/Entwicklung/NetBeansProjects/C-Standard/CStandard"
.LASF0:
	.string	"long unsigned int"
.LASF20:
	.string	"runCreateProcess"
.LASF15:
	.string	"statusPtr"
.LASF8:
	.string	"char"
.LASF12:
	.string	"long long unsigned int"
.LASF1:
	.string	"unsigned char"
.LASF18:
	.string	"processes/create_process.c"
.LASF6:
	.string	"long int"
.LASF13:
	.string	"resCreate"
.LASF21:
	.string	"createProcess"
.LASF16:
	.string	"normExit"
.LASF2:
	.string	"short unsigned int"
.LASF4:
	.string	"signed char"
.LASF14:
	.string	"ppid"
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
