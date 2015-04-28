//
//  LoginViewController.m
//  智睿达客户端
//
//  Created by tony1220 on 15/4/27.
//  Copyright (c) 2015年 tony1220. All rights reserved.
//

#import "LoginViewController.h"
#import "LoginView.h"
#import "RegisterViewController.h"
@interface LoginViewController ()
{
    LoginView *_loginView;
}


@end

@implementation LoginViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    [self initializeAppearance];
    // Do any additional setup after loading the view.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (void)initializeAppearance
{
    _loginView = [[[NSBundle mainBundle]loadNibNamed:@"Login" owner:nil options:nil]lastObject];
    _loginView.frame = CGRectMake(0, 0, SCREEN_Width, SCREEN_Height);
    [_loginView.registerButton addTarget:self action:@selector(goRegister) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:_loginView];
}

//进入注册页面

- (void)goRegister
{
    RegisterViewController *registerVc = [[RegisterViewController alloc]init];
    [self.navigationController pushViewController:registerVc animated:YES];
}

@end
